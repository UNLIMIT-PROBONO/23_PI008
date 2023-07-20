package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AverageRequestDto {

    private Double callAverage;

    private Double electricityAverage;

    private Double waterAverage;

}

