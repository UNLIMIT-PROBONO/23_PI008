package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.schedule.repository.ScheduleRepository;
import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleResponse> returnAfterToday(String accessToken, Long userId) {
        List<Schedule> schedules = scheduleRepository.returnAfterToday(accessToken, userId);
        return schedules.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public ScheduleResponse getSchedule(String accessToken, Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }
        return convertToResponse(schedule);
    }

    @Override
    public List<ScheduleResponse> getHistory(String accessToken, Long userId) {
        List<Schedule> schedules = scheduleRepository.findByUserId(userId);
        return schedules.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public ScheduleResponse addSchedule(String accessToken, ScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setUserId(request.getUserId());
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setActivated("ACTIVATED");
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(savedSchedule);
    }

    @Override
    public ScheduleResponse updateSchedule(String accessToken, Long scheduleId, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(updatedSchedule);
    }

    @Override
    public void deleteSchedule(String accessToken, Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }
        scheduleRepository.delete(schedule);
    }

    private ScheduleResponse convertToResponse(Schedule schedule) {
        ScheduleResponse response = new ScheduleResponse();
        response.setScheduleId(schedule.getId());
        return response;
    }
}

