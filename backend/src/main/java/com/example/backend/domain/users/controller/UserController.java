package com.example.backend.domain.users.controller;

import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.service.UserService;
import com.example.backend.global.jwt.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> addUser(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody UserRequestDto userRequestDto) {
        userService.addUser(customUserDetails.getUsername(), userRequestDto);
        return ResponseEntity.ok().build();
    }

}