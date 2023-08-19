package com.example.backend.domain.users.controller;

import com.example.backend.domain.users.exception.GenderNotFoundException;
import com.example.backend.domain.users.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(GenderNotFoundException.class)
    public ResponseEntity<String> catchGenderNotFoundException(GenderNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> catchUserNotFoundException(UserNotFoundException e) {
        log.error((e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
