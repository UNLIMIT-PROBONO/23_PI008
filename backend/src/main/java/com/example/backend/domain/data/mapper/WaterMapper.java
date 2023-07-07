package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.AverageRequestDto;
import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Water;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WaterMapper {

    public Water toEntity(DataRequestDto dto) {
        return Water.builder()
                .userId(dto.getUserId())
                .usage(dto.getWater())
                .build();
    }

    public DataResponseDto fromEntity(Water entity) {
        return DataResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .waterData(entity.getUsage())
                .createdAt(entity.getCreatedAt())
                .build();
    }


    public AverageRequestDto toAverageDataDto(double callAverage, double electricityAverage, double waterAverage) {
        return AverageRequestDto.builder()
                .callAverage(callAverage)
                .electricityAverage(electricityAverage)
                .waterAverage(waterAverage)
                .build();
    }



}
