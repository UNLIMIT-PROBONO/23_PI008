package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class DataResponseDto {

    private String userId;

    private int callData ;

    private int electricityData;

    private int waterData ;

    private String createdAt;



}
