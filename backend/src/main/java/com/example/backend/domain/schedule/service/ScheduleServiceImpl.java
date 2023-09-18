package com.example.backend.domain.schedule.service;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.schedule.repository.ScheduleRepository;
import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.repository.ManagerRepository;
import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import com.example.backend.domain.users.entity.Users;
import com.example.backend.domain.users.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Override
    public ScheduleResponse createSchedule(String username, ScheduleRequest request) {
        Managers managerEntity = managerRepository.findByLoginIdAndIsActivated(username, true)
                .orElseThrow(ManagersNotFoundException::new);

        Users userEntity = userRepository.findByIdAndIsActivated(request.getUserId(), true)
                .orElseThrow(() -> new RuntimeException("User not found: " + request.getUserId()));

        Schedule schedule = Schedule.builder()
                .manager(managerEntity)
                .user(userEntity)
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

        schedule.setUser(userRepository.findByIdAndIsActivated(request.getUserId(), true)
                .orElseThrow(() -> new RuntimeException("User not found: " + request.getUserId())));

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


    @Override
    public List<ScheduleResponse> getSchedulesByYearAndMonth(int year, int month) {
        List<Schedule> schedules = scheduleRepository.findByYearAndMonth(year, month);

        return schedules.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<ScheduleResponse> getThisWeekSchedules() {
        List<Schedule> schedules = scheduleRepository.findThisWeekSchedules();

        return schedules.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
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
