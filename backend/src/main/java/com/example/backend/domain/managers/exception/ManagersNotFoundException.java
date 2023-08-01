package com.example.backend.domain.managers.exception;

public class ManagersNotFoundException extends RuntimeException {

    public ManagersNotFoundException() {
        super("해당하는 회원 정보가 존재하지 않습니다.");
    }
}
