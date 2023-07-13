package com.example.backend.domain.managers.mapper;

import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.SignupResponseDto;
import com.example.backend.domain.managers.entity.Managers;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//만약 매핑되지 않는 필드가 있으면 값을 null로 넣고, 경고를 함
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ManagersMapper {

    Managers dtoToEntity(SignupRequestDto signupRequestDto);

    SignupResponseDto entityToDto(Managers manager);
}
