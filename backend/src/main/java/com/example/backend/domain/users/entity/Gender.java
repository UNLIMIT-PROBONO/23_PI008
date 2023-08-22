package com.example.backend.domain.users.entity;

import com.example.backend.domain.users.exception.GenderNotFoundException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Gender {

    MALE("남성"),
    FEMALE("여성");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public static Gender getGenderByName(String name) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getName().equals(name))
                .findAny().orElseThrow(GenderNotFoundException::new);
    }
}
