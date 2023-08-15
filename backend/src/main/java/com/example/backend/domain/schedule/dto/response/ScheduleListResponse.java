package com.example.backend.domain.schedule.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleListResponse {
    private final List<ScheduleResponse> schedules;

    public ScheduleListResponse(List<ScheduleResponse> schedules) {
        this.schedules = schedules;
    }

}
