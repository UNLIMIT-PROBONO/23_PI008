package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsageResponseDto {

    private Long userId;

    private String date;

    private int call;
    private int electricity;
    private int water;

    private double callAvg;
    private double electricityAvg;
    private double waterAvg;
    
}

