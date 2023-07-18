package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@Setter
@AllArgsConstructor
public class DataResponseDto {

    private Long userId;

    private int callData ;

    private int electricityData;

    private int waterData ;

    private String createdAt;

}
