package com.example.backend.domain.managers.mapper;

import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.ManagerResponseDto;
import com.example.backend.domain.managers.entity.Managers;
import org.springframework.stereotype.Component;

@Component
public class ManagersMapper {

    public Managers toEntity(SignupRequestDto signupRequestDto) {
        return Managers.builder()
                .loginId(signupRequestDto.getLoginId())
                .password(signupRequestDto.getPassword())
                .name(signupRequestDto.getName())
                .adminArea(signupRequestDto.getAdminArea())
                .phoneNumber(signupRequestDto.getPhoneNumber())
                .build();
    }

    public ManagerResponseDto fromEntity(Managers manager) {
        return ManagerResponseDto.builder()
                .name(manager.getName())
                .adminArea(manager.getAdminArea())
                .phoneNumber(manager.getPhoneNumber())
                .createdAt(manager.getCreatedAt())
                .updatedAt(manager.getUpdatedAt())
                .isActivated(manager.isActivated())
                .build();
    }
}

//import com.example.backend.domain.managers.dto.request.SignupRequestDto;
//import com.example.backend.domain.managers.dto.response.ManagerResponseDto;
//import com.example.backend.domain.managers.dto.response.SignupResponseDto;
//import com.example.backend.domain.managers.entity.Managers;
//import org.mapstruct.Mapper;
//import org.mapstruct.ReportingPolicy;

////만약 매핑되지 않는 필드가 있으면 값을 null로 넣고, 경고를 함
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
//public interface ManagersMapper {
//
//    Managers signupRequestDtoToEntity(SignupRequestDto signupRequestDto);
//
//    SignupResponseDto entityToSignupResponseDto(Managers manager);
//
//    ManagerResponseDto entityToManagerResponseDto(Managers manager);
//}
