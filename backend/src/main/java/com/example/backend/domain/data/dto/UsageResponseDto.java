package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsageResponseDto {

    private Long userId;
    private int call;
    private int callAvg;
    private int water;
    private int waterAvg;
    private int elec;
    private int elecAvg;
    private String date;

}

