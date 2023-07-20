package com.example.backend.domain.managers.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerResponseDto {

    private String name;

    private String adminArea;

    private String phoneNumber;

    private String createdAt;

    private String updatedAt;

    private boolean isActivated;
}
