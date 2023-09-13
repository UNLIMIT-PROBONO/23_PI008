package com.example.backend.domain.schedule.dto.request;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @Getter
    private Users user;
    @Getter
    private Managers manager;
}
