package com.example.backend.domain.managers.controller;

import com.example.backend.domain.managers.dto.request.LoginRequestDto;
import com.example.backend.domain.managers.dto.request.SignupRequestDto;
import com.example.backend.domain.managers.service.ManagersApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagersApiController {

    private final ManagersApiService managersApiService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        return managersApiService.signUp(signupRequestDto);
    }

    @GetMapping("/signup/{id}")
    public ResponseEntity<?> duplicateId(@PathVariable("id") String id) {
        return managersApiService.duplicateId(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        return managersApiService.login(loginRequestDto);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
