package com.example.backend.domain.data.dto;

import lombok.*;

@Data
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {

    private Long userId;

    private int call;

    private int electricity;

    private int water;

}
