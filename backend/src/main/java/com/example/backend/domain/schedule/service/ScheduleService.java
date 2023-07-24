package com.example.backend.domain.schedule.service;

import com.example.schedulemanagement.dto.request.ScheduleRequest;
import com.example.schedulemanagement.dto.response.ScheduleResponse;
import java.util.List;

public interface ScheduleService {
    List<ScheduleResponse> returnAfterToday(String accessToken, Long userId);

    ScheduleResponse getSchedule(String accessToken, Long scheduleId);

    List<ScheduleResponse> getHistory(String accessToken, Long userId);

    ScheduleResponse addSchedule(String accessToken, ScheduleRequest request);

    ScheduleResponse updateSchedule(String accessToken, Long scheduleId, ScheduleRequest request);

    void deleteSchedule(String accessToken, Long scheduleId);
}

