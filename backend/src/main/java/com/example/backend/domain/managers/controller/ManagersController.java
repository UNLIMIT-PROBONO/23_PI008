package com.example.backend.domain.managers.controller;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.UpdateRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.dto.response.ManagerResponseDto;
import com.example.backend.domain.managers.service.ManagersService;
import com.example.backend.global.jwt.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagersController {

    private final ManagersService managersService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        managersService.signUp(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //아이디 중복 확인
    @GetMapping("/signup/{id}")
    public ResponseEntity<Void> duplicateId(@PathVariable("id") String id) {

        if (managersService.duplicateId(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok().build();
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(HttpServletResponse response, @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(managersService.login(response, loginRequestDto));
    }

    //매니저 정보 조회
    @GetMapping("/")
    public ResponseEntity<ManagerResponseDto> getManager(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(managersService.getManager(customUserDetails.getUsername()));
    }

    //매니저 정보 수정
    @PutMapping("/")
    public ResponseEntity<ManagerResponseDto> updateManager(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody UpdateRequestDto updateRequestDto) {
        return ResponseEntity.ok(managersService.updateManager(customUserDetails.getUsername(), updateRequestDto));
    }

    //회원탈퇴
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteManager(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        managersService.deleteManager(customUserDetails.getUsername());
        return ResponseEntity.ok().build();
    }
}
