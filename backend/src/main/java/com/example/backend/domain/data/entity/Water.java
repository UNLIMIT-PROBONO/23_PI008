package com.example.backend.domain.data.entity;

import com.example.backend.domain.users.entity.Users;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@Table(name="water")
public class Water {

    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "usage", nullable = false)
    private int usage ;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Getter
    @Column(name = "created_at" , updatable = false)
    @Builder.Default
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));


    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
