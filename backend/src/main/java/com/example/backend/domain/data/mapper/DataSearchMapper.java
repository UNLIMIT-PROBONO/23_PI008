package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSearchMapper {

    public DataSearchResponseDto toDto(Long userId, String date, int call, int electricity, int water) {
        return DataSearchResponseDto.builder()
                .userId(userId)
                .date(date)
                .call(call)
                .electricity(electricity)
                .water(water)
                .build();
    }

}
