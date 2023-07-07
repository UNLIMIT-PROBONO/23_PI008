package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AverageRequestDto {

    private Double callAverage;

    private Double electricityAverage;

    private Double waterAverage;

}

