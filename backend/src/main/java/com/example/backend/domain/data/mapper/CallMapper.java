package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Call;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class CallMapper {

    public Call toEntity(DataRequestDto dto) {
        return Call.builder()
                .userId(dto.getUserId())
                .date(new Date())
                .usage(dto.getCall())
                .build();
    }

    public DataResponseDto fromEntity(Call entity) {
        return DataResponseDto.builder()
                .userId(String.valueOf(entity.getUserId()))
                .callData(entity.getUsage())
                .date(entity.getDate())
                .build();
    }

}

