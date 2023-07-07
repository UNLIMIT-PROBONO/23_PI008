package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.AverageRequestDto;
import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Call;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CallMapper {

    public Call toEntity(DataRequestDto dto) {
        return Call.builder()
                .userId(dto.getUserId())
                .usage(dto.getCall())
                .build();
    }

    public DataResponseDto fromEntity(Call entity) {
        return DataResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .callData(entity.getUsage())
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

