package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Water;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class WaterMapper {

    public Water toEntity(DataRequestDto dto) {
        return Water.builder()
                .userId(dto.getUserId())
                .date(new Date())
                .usage(dto.getWater())
                .build();
    }

    public DataResponseDto fromEntity(Water entity) {
        return DataResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .waterData(entity.getUsage())
                .date(entity.getDate())
                .build();
    }

}
