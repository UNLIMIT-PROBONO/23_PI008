package com.example.backend.domain.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String name ;

    private String phoneNum ;

    private String address ;

    // 추후 enum 으로 수정
    private String gender ;

    private String birth ;

    private String health ;

    private String check ;
}
