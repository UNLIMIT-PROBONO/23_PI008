package com.example.backend.domain.users.entity;

import com.example.backend.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@Table(name="users")
public class Users extends BaseEntity {

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

//    @Column(name = "admin_id", nullable = false)
//    private Long adminId ;

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum ;

    @Column(name = "address", nullable = false)
    private String address ;

    @Column(name = "gender", nullable = false)
    private String gender ;

    @Column(name = "birth", nullable = false)
    private String birth ;

    @Column(name = "health", nullable = false)
    private String health ;

    @Column(name = "user_check", nullable = false)
    private String check ;

}