package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AverageResponseDto {

    private String userId;

    private Double callAverage;

    private Double electricityAverage;

    private Double waterAverage;

    private String startDate;

    private String endDate;


}
