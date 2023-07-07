package com.example.backend.domain.managers.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDto {

    private String loginId;

    private String name;

    private String grantType; //JWT 인증 타입, 이후 토큰에 prefix로 붙여줘야함

    private String token;
}