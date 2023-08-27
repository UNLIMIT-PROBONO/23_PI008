package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import java.util.List;

public interface ScheduleService {
    ScheduleResponse createSchedule(ScheduleRequest request);
    ScheduleResponse getSchedule(Long scheduleId);
    List<ScheduleResponse> getAllSchedules();
    ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request);
    void deleteSchedule(Long scheduleId);
    List<ScheduleResponse> getHistory(Long userId);
}
