package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public ScheduleResponse createSchedule(ScheduleRequest request) {
        Schedule schedule = Schedule.builder()
                .user(request.getUser())
                .manager(request.getManager())
                .title(request.getTitle())
                .content(request.getContent())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .activated(true)
                .build();

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(savedSchedule);
    }

    @Override
    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }

        schedule.setManager(request.getManager());
        schedule.setUser(request.getUser());
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setStartDate(request.getStartDate());
        schedule.setEndDate(request.getEndDate());
        schedule.setUpdatedAt(LocalDateTime.now());

        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return convertToResponse(updatedSchedule);
    }

    @Override
    @Transactional
    public ScheduleResponse getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        return convertToResponse(schedule);
    }

    @Override
    @Transactional
    public List<ScheduleResponse> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if (schedule == null) {
            throw new RuntimeException("Schedule not found: " + scheduleId);
        }

        scheduleRepository.delete(schedule);
    }

    @Override
    @Transactional
    public List<ScheduleResponse> getHistory(Long userId) {
        List<Schedule> schedules = scheduleRepository.findByUserId(userId);
        return schedules.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private ScheduleResponse convertToResponse(Schedule schedule) {
        if (schedule == null) {
            return null;
        }

        return ScheduleResponse.builder()
                .scheduleId(schedule.getScheduleId())
                .managerId(schedule.getManager().getId())
                .userId(schedule.getUser().getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .startDate(schedule.getStartDate())
                .endDate(schedule.getEndDate())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .activated(schedule.isActivated())
                .build();
    }
}
