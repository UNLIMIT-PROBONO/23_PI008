package com.example.backend.domain.managers.mapper;

import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.dto.response.ManagerResponseDto;
import com.example.backend.domain.managers.entity.Managers;
import org.springframework.stereotype.Component;

@Component
public class ManagersMapper {

    public Managers toEntity(SignupRequestDto signupRequestDto) {
        return Managers.builder()
                .loginId(signupRequestDto.getLoginId())
                .password(signupRequestDto.getPassword())
                .name(signupRequestDto.getName())
                .adminArea(signupRequestDto.getAdminArea())
                .phoneNumber(signupRequestDto.getPhoneNumber())
                .build();
    }

    public LoginResponseDto fromEntityToLoginResponse(Managers managers) {
        return LoginResponseDto.builder()
                .loginId(managers.getLoginId())
                .name(managers.getName())
                .build();
    }

    public ManagerResponseDto fromEntityToManagerResponse(Managers manager) {
        return ManagerResponseDto.builder()
                .name(manager.getName())
                .adminArea(manager.getAdminArea())
                .phoneNumber(manager.getPhoneNumber())
                .createdAt(manager.getCreatedAt())
                .updatedAt(manager.getUpdatedAt())
                .isActivated(manager.isActivated())
                .build();
    }
}
