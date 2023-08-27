package com.example.backend.domain.schedule.entity;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Managers manager;

    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean activated;

    @Builder
    public Schedule(Long scheduleId, Users user, Managers manager, String title, String content,
                          LocalDateTime startDate, LocalDateTime endDate, LocalDateTime createdAt,
                          LocalDateTime updatedAt, boolean activated) {
        this.scheduleId = scheduleId;
        this.user = user;
        this.manager = manager;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.activated = activated;
    }

    public Schedule() {

    }
}
