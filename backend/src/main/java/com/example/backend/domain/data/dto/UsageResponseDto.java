package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsageResponseDto {

    private Long userId;
    private int call;
    private double callAvg;
    private int water;
    private double waterAvg;
    private int electricity;
    private double electricityAvg;
    private String date;

}

