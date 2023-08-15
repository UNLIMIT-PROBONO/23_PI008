package com.example.backend.domain.schedule.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRequest {
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}