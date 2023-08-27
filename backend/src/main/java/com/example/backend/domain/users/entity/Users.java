package com.example.backend.domain.users.entity;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="users")
public class Users extends BaseEntity {

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Managers managers;

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum ;

    @Column(name = "address", nullable = false)
    private String address ;

    @Enumerated(EnumType.STRING) //enum 이름을 db에 저장
    @Column(name = "gender", nullable = false)
    private Gender gender ;

    @Column(name = "birth", nullable = false)
    private String birth ;

    @Column(name = "health")
    private String health ;

    @Column(name = "user_check")
    private String check ;

}