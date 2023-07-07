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

    private Date date ;  // 어떻게 해야할지 모르겠어

}
