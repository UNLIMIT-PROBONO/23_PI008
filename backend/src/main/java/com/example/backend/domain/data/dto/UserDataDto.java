package com.example.backend.domain.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {

    private Long userId;

    private int call;

    private int electricity;

    private int water;

}
