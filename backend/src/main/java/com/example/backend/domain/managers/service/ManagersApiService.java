package com.example.backend.domain.managers.service;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.dto.response.SignupResponseDto;
import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.mapper.ManagersMapper;
import com.example.backend.domain.managers.repository.ManagerRepository;
import com.example.backend.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ManagersApiService {

    private final ManagerRepository managerRepository;
    private final ManagersMapper managersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public ResponseEntity<?> signUp(SignupRequestDto signupRequestDto) {

        //비밀번호 암호화
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        signupRequestDto.setPassword(password);

        //회원정보 저장
        Managers managerEntity = managerRepository.save(managersMapper.dtoToEntity(signupRequestDto));

        SignupResponseDto signupResponseDto = managersMapper.entityToDto(managerEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponseDto);
    }

    public ResponseEntity<?> duplicateId(String loginId) {

        //아이디 중복 확인
        if (managerRepository.existsByLoginId(loginId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 아이디입니다.");
        }

        return ResponseEntity.status(HttpStatus.OK).body("등록 가능한 아이디입니다.");
    }

    public ResponseEntity<?> login(LoginRequestDto loginRequestDto) {

        //등록된 아이디인지 확인
        Managers manager = managerRepository.findByLoginId(loginRequestDto.getLoginId()).orElseThrow(
                () -> new BadCredentialsException("로그인에 실패하였습니다.")
        );

        //비밀번호가 맞는지 확인
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), manager.getPassword())) {
            throw new BadCredentialsException("로그인에 실패하였습니다.");
        }

        //토큰 생성
        String token = jwtProvider.createToken(manager.getLoginId(), manager.getName());

        LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                .loginId(manager.getLoginId())
                .name(manager.getName())
                .grantType("Bearer")
                .token(token)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
    }
}