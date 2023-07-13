package com.example.backend.domain.managers.controller;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.ManagerRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.service.ManagersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagersController {

    private final ManagersService managersService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        return managersService.signUp(signupRequestDto);
    }

    //아이디 중복 확인
    @GetMapping("/signup/{id}")
    public ResponseEntity<?> duplicateId(@PathVariable("id") String id) {
        return managersService.duplicateId(id);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        return managersService.login(loginRequestDto);
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
}
