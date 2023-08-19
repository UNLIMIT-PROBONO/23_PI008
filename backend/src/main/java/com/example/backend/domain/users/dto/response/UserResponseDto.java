package com.example.backend.domain.users.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {

    private Long userId;

    private Long adminId;

    private String name;

    private String phoneNumber;

    private String address;

    private String gender;

    private String birth;

    private String health;

    private String check;

    private String createdAt;

    private String updatedAt;

    private boolean isActivated;
}
