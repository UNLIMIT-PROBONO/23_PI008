package com.example.backend.domain.managers.dto.response;

import lombok.Builder;

@Builder
public class LoginResponseDto {

    private String loginId;

    private String name;
}