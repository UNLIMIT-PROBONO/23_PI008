package com.example.backend.domain.managers.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManagerResponseDto {

    private String name;

    private String adminArea;

    private String phoneNumber;

    private String createdAt;

    private String updatedAt;

    private boolean isActivated;
}
