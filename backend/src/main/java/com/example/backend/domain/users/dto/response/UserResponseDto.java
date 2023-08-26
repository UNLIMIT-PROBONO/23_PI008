package com.example.backend.domain.users.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    private boolean activated;

    @Builder
    public UserResponseDto(Long userId, Long adminId, String name, String phoneNumber, String address, String gender,
                String birth, String health, String check, String createdAt, String updatedAt, boolean activated) {
        this.userId = userId;
        this.adminId = adminId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
        this.health = health;
        this.check = check;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.activated = activated;
    }
}
