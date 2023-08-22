package com.example.backend.domain.users.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {

    private String name ;

    private String phoneNum ;

    private String address ;

    private String gender ;

    private String birth ;

    private String health ;

    private String check ;
}
