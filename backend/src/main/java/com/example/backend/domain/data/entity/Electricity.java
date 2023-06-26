package com.example.backend.domain.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@Entity
@Setter
@Builder
@NoArgsConstructor
@Table(name="electricity")
public class Electricity {

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "user_id", nullable = false)
    private Long userId ;

    @Column(name = "date", nullable = false)
    private Date date ;

    @Column(name = "usage", nullable = false)
    private int usage ;

}

