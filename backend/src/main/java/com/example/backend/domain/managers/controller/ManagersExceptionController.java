package com.example.backend.domain.managers.controller;

import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ManagersExceptionController {

    @ExceptionHandler(ManagersNotFoundException.class)
    public ResponseEntity<String> catchManagersNotFoundException(ManagersNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
