package com.example.backend.domain.users.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("해당하는 관리대상자 정보가 존재하지 않습니다.");
    }
}
