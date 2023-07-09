package com.example.backend.domain.managers.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    private String loginId;

    private String password;

    private String name;

    private String adminArea;

    private String phoneNum;
}
