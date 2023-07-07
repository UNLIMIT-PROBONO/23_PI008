package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Electricity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//import java.util.Date;

@Component
@RequiredArgsConstructor
public class ElectricityMapper {

    public Electricity toEntity(DataRequestDto dto) {
        return Electricity.builder()
                .userId(dto.getUserId())
                .date(new Date())
                .usage(dto.getElectricity())
                .build();
    }

    public DataResponseDto fromEntity(Electricity entity) {
        return DataResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .electricityData(entity.getUsage())
                .date(entity.getDate())
                .build();
    }
}

