package com.example.backend.domain.data.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRequestDto {

    private Long userId ;

    private int call ;

    private int electricity ;

    private int water ;

    private List<UserDataDto> data;

}
