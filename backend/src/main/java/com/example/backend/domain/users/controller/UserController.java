package com.example.backend.domain.users.controller;

import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.mapper.UserMapper;
import com.example.backend.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserRequestDto userRequestDto) {
        userService.addUser(userRequestDto);
        return ResponseEntity.ok().build();
    }

}
