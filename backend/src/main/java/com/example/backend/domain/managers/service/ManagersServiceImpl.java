package com.example.backend.domain.managers.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.UpdateRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.dto.response.ManagerResponseDto;
import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import com.example.backend.domain.managers.mapper.ManagersMapper;
import com.example.backend.domain.managers.repository.ManagerRepository;
import com.example.backend.global.jwt.JwtProperties;
import com.example.backend.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ManagersServiceImpl implements ManagersService{

    private final ManagerRepository managerRepository;
    private final ManagersMapper managersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    //회원가입
    @Transactional
    public void signUp(SignupRequestDto signupRequestDto) {

        //비밀번호 암호화
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        signupRequestDto.setPassword(password);

        //회원정보 저장
        managerRepository.save(managersMapper.toEntity(signupRequestDto));
    }

    //아이디 중복 확인
    public boolean duplicateId(String loginId) {
        return managerRepository.existsByLoginId(loginId);
    }

    //로그인
    public LoginResponseDto login(HttpServletResponse response, LoginRequestDto loginRequestDto) {

        //등록된 아이디인지 확인
        Managers manager = managerRepository.findByLoginIdAndIsActivated(loginRequestDto.getLoginId(), true).orElseThrow(
                () -> new BadCredentialsException("로그인에 실패하였습니다.")
        );

        //비밀번호가 맞는지 확인
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), manager.getPassword())) {
            throw new BadCredentialsException("로그인에 실패하였습니다.");
        }

        //토큰 생성
        String accessToken = jwtProvider.createAccessToken(manager.getLoginId(), manager.getName());

        //쿠키 생성
        Cookie cookie = new Cookie("accessToken", "Bearer " + accessToken);
        cookie.setMaxAge(60 * 60 * 6); //유효시간 6시간
        cookie.setPath("/"); //모든 경로에서 접근 가능
        cookie.setHttpOnly(true); //서버만 쿠키에 접근 가능

        response.addCookie(cookie);

        return managersMapper.fromEntityToLoginResponse(manager);
    }

    //매니저 정보 조회
    public ManagerResponseDto getManager(String loginId) {

        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(loginId, true)
                .orElseThrow(ManagersNotFoundException::new);

        return managersMapper.fromEntityToManagerResponse(managerEntity);
    }

    //매니저 정보 수정
    @Transactional
    public ManagerResponseDto updateManager(String loginId, UpdateRequestDto updateRequestDto) {

        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(loginId, true)
                .orElseThrow(ManagersNotFoundException::new);

        //비밀번호 암호화
        String password = passwordEncoder.encode(updateRequestDto.getPassword());

        //정보 수정
        managerEntity.update(password, updateRequestDto.getAdminArea(), updateRequestDto.getPhoneNumber());

        return managersMapper.fromEntityToManagerResponse(managerEntity);
    }

    //회원탈퇴
    @Transactional
    public void deleteManager(String loginId) {

        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(loginId, true)
                .orElseThrow(ManagersNotFoundException::new);

        managerEntity.setActivated(false);
    }

    //토큰 값 중 로그인 아이디 추출
    public String extractLoginId(HttpServletRequest request) {

        //쿠키 추출
        String cookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("accessToken"))
                .findFirst().map(Cookie::getValue)
                .orElse(null);

        //토큰 값만 남기기
        String accessToken = cookie.replace(JwtProperties.TOKEN_PREFIX, "");

        //토큰 값 중 로그인 아이디 추출
        return JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(accessToken)
                .getClaim("loginId").asString();
    }
}