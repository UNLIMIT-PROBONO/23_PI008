package com.example.backend.domain.managers.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequestDto {

    private String password;

    private String adminArea;

    private String phoneNumber;
}
