package com.example.backend.domain.schedule.dto.request;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.entity.Users;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {
    private Long managerId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Getter
    private Users user;
    @Getter
    private Managers manager;

}
