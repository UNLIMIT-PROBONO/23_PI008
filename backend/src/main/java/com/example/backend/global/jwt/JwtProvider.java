package com.example.backend.global.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    public String createAccessToken(String loginId, String name) {

        return JWT.create()
                .withSubject(loginId)
                .withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
                .withClaim("loginId", loginId)
                .withClaim("name", name)
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
    }
}
