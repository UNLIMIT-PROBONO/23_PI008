package com.example.backend.domain.managers.dto.request;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String loginId;

    private String password;
}
