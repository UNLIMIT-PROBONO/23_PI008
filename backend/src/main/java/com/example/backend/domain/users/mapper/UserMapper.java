package com.example.backend.domain.users.mapper;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.dto.request.UserRequestDto;
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

}