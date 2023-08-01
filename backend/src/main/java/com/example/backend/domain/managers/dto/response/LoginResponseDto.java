package com.example.backend.domain.managers.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDto {

    private String loginId;

    private String name;
}