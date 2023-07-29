package com.example.backend.global.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import com.example.backend.domain.managers.repository.ManagerRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final ManagerRepository managerRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, ManagerRepository managerRepository) {
        super(authenticationManager);
        this.managerRepository = managerRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request.getCookies() == null) {
            chain.doFilter(request, response);
            return;
        }

        //쿠키 추출
        String cookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("accessToken"))
                .findFirst().map(Cookie::getValue)
                .orElse(null);

        if (cookie == null || !cookie.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        String accessToken = cookie.replace(JwtProperties.TOKEN_PREFIX, "");

        //토큰 검증
        String loginId = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(accessToken)
                .getClaim("loginId").asString();

        if (loginId != null) {

            Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(loginId, true)
                    .orElseThrow(ManagersNotFoundException::new);

            //인증은 토큰 검증시 끝. 인증을 하기 위해서가 아닌 스프링 시큐리티가 수행해주는 권한 처리를 위해
            //아래와 같이 토큰을 만들어서 Authentication 객체를 강제로 만들고 그걸 세션에 저장
            CustomUserDetails customUserDetails = new CustomUserDetails(managerEntity);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    customUserDetails, //나중에 컨트롤러에서 DI해서 쓸 때 사용하기 편함
                    null, //패스워드는 모르니까 null 처리, 어차피 지금 인증하는게 아니니까
                    customUserDetails.getAuthorities());

            //강제로 시큐리티의 세션에 접근하여 값 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
