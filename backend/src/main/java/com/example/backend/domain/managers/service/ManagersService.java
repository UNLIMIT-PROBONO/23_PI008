package com.example.backend.domain.managers.service;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.ManagerRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.dto.response.ManagerResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ManagersService {

    void signUp(SignupRequestDto signupRequestDto);

    boolean duplicateId(String loginId);

    LoginResponseDto login(HttpServletResponse response, LoginRequestDto loginRequestDto);

    ManagerResponseDto getManager(HttpServletRequest request);

    ManagerResponseDto updateManager(HttpServletRequest request, ManagerRequestDto managerRequestDto);

    void deleteManager(HttpServletRequest request);
}
