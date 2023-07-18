package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataSearchResponseDto;
import com.example.backend.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSearchMapper {
    public DataSearchResponseDto toDto(Users users, String date, int call, int electricity, int water) {
        return DataSearchResponseDto.builder()
                .userId(users.getId())
                .date(date)
                .call(call)
                .electricity(electricity)
                .water(water)
                .build();
    }

}
