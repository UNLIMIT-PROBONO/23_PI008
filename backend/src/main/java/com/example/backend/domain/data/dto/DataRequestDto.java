package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataRequestDto {

    private Long userId ;

    private int call ;

    private int electricity ;

    private int water ;

    private List<UserDataDto> data;

}
