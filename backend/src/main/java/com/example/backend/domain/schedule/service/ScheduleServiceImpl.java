package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponse getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        return convertToResponse(schedule);
    }

    @Override
    public List<ScheduleResponse> getHistory(Long userId) {
        List<Schedule> schedules = scheduleRepository.findByUserId(userId);
        return schedules.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public ScheduleResponse addSchedule(ScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setUserId(request.getUserId());
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setUpdatedAt(LocalDateTime.now());
        schedule.setActivated("ACTIVATED");
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(savedSchedule);
    }

    @Override
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }
        schedule.setUserId(request.getUserId());
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setUpdatedAt(LocalDateTime.now());
        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(updatedSchedule);
    }

    @Override
    public void deleteSchedule(List<Long> scheduleIdList) {
        scheduleRepository.deleteAllByIdIn(scheduleIdList);
    }

    private ScheduleResponse convertToResponse(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        ScheduleResponse response = new ScheduleResponse();
        response.setScheduleId(schedule.getScheduleId());
        response.setUserId(schedule.getUserId());
        response.setTitle(schedule.getTitle());
        response.setContent(schedule.getContent());
        response.setStartDate(schedule.getStartDate());
        response.setEndDate(schedule.getEndDate());
        response.setCreatedAt(schedule.getCreatedAt());
        response.setUpdatedAt(schedule.getUpdatedAt());
        response.setActivated(schedule.getActivated());
        return response;
    }
}
