package com.example.backend.domain.managers.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private String loginId;

    private String password;

    private String name;

    private String adminArea;

    private String phoneNum;

    private String createdAt;

    private String updatedAt;

    private boolean isActivated;
}