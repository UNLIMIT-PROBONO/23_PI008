package com.example.backend.domain.users.exception;

public class GenderNotFoundException extends RuntimeException{
    public GenderNotFoundException() {
        super("해당하는 성별 정보가 존재하지 않습니다.");
    }
}
