package com.example.backend.domain.managers.controller;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.ManagerRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.dto.response.LoginResponseDto;
import com.example.backend.domain.managers.service.ManagersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    //아이디 중복 확인
    @GetMapping("/signup/{id}")
    public ResponseEntity<?> duplicateId(@PathVariable("id") String id) {
        return managersService.duplicateId(id);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(HttpServletResponse response, @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(managersService.login(response, loginRequestDto));
    }

    //매니저 정보 조회
    @GetMapping("/")
    public ResponseEntity<?> getManager(@RequestHeader("Authorization") String token) {
        return managersService.getManager(token);
    }

    //매니저 정보 수정
    @PutMapping("/")
    public ResponseEntity<?> updateManager(@RequestHeader("Authorization") String token, @RequestBody ManagerRequestDto managerRequestDto) {
        return managersService.updateManager(token, managerRequestDto);
    }

    //회원탈퇴
    @DeleteMapping("/")
    public ResponseEntity<?> deleteManager(@RequestHeader("Authorization") String token) {
        return managersService.deleteManager(token);
    }
}
