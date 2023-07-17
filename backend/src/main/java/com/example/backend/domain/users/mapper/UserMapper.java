package com.example.backend.domain.users.mapper;

import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public Users toEntity (UserRequestDto userRequestDto) {
        return Users.builder()
                .name(userRequestDto.getName())
                .phoneNum(userRequestDto.getPhoneNum())
                .address(userRequestDto.getAddress())
                .gender(userRequestDto.getGender())
                .birth(userRequestDto.getBirth())
                .health(userRequestDto.getHealth())
                .check(userRequestDto.getCheck())
                .build();
    }

}
