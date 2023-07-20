package com.example.backend.global.jwt;

public interface JwtProperties {

    String SECRET = "L6mZBzOEMGGQHvoGCkdwtqJqenS6jSeJc7ue47jdesscsmglMIfYHgLHpH8dgQ8V";

    int EXPIRATION_TIME = 60000 * 60 * 3; // 3시간

    String TOKEN_PREFIX = "Bearer ";
}
