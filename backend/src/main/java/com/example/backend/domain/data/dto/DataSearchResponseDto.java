package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataSearchResponseDto {

    private Long userId ;

    private String date ;

    private int call ;

    private int electricity ;

    private int water;

}
