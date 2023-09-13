package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.schedule.repository.ScheduleRepository;
import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.repository.ManagerRepository;
import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ManagerRepository managerRepository;

    @Override
    public ScheduleResponse createSchedule(String username, ScheduleRequest request) {
        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(username, true)
                .orElseThrow(ManagersNotFoundException::new);

        Schedule schedule = Schedule.builder()
                .manager(managerEntity)
                .user(request.getUser())
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
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found: " + scheduleId));

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
    public ScheduleResponse getSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found: " + scheduleId));

        return convertToResponse(schedule);
    }

    @Override
    public List<ScheduleResponse> getAllSchedules(String username) {

        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(username, true)
                .orElseThrow(ManagersNotFoundException::new);

        List<Schedule> schedules = scheduleRepository.findByManager(managerEntity);

        return schedules.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found: " + scheduleId));

        schedule.setActivated(false);

        scheduleRepository.save(schedule);
    }

    private ScheduleResponse convertToResponse(Schedule schedule) {
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
