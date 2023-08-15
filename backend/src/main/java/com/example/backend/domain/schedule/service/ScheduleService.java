package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleListResponse;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import java.util.List;

public interface ScheduleService {

    ScheduleListResponse getAllSchedules();
    ScheduleResponse getSchedule(Long scheduleId);
    List<ScheduleResponse> getHistory(Long userId);
    ScheduleResponse addSchedule(ScheduleRequest request);
    ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request);
    void deleteSchedule(Long scheduleId);
}