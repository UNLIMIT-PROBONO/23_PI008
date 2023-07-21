package com.example.backend.domain.managers.entity;

import com.example.backend.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Managers extends BaseEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id", unique = true, nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "admin_area", nullable = false)
    private String adminArea;

    @Column(name = "phone_num", nullable = false)
    private String phoneNumber;

    @Builder
    public Managers(String loginId, String password, String name, String adminArea, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.adminArea = adminArea;
        this.phoneNumber = phoneNumber;
    }
}