package com.example.backend.domain.users.mapper;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.dto.response.UserResponseDto;
import com.example.backend.domain.users.entity.Gender;
import com.example.backend.domain.users.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users toEntity (UserRequestDto userRequestDto, Managers manager, Gender gender) {
        return Users.builder()
                .managers(manager)
                .name(userRequestDto.getName())
                .phoneNum(userRequestDto.getPhoneNum())
                .address(userRequestDto.getAddress())
                .gender(gender)
                .birth(userRequestDto.getBirth())
                .health(userRequestDto.getHealth())
                .check(userRequestDto.getCheck())
                .build();
    }

    public UserResponseDto fromEntity(Users user) {
        return UserResponseDto.builder()
                .userId(user.getId())
                .adminId(user.getManagers().getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNum())
                .address(user.getAddress())
                .gender(user.getGender().getName())
                .birth(user.getBirth())
                .health(user.getHealth())
                .check(user.getCheck())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .activated(user.isActivated())
                .build();
    }
}