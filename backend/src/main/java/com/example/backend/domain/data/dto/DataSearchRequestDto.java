package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataSearchRequestDto {

    private String startDate ;

    private String endDate ;


}