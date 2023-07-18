package com.example.backend.domain.data.dto;

import lombok.*;


@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AverageResponseDto {

    private Long userId;

    private double callAverage;
    private double waterAverage;
    private double electricityAverage;

    private String startDate;
    private String endDate;

}