package com.backend.domain.schedule.service;

import com.backend.domain.schedule.dto.response.ScheduleResponse;
import com.backend.domain.schedule.entity.Schedule;
import com.backend.domain.schedule.mapper.ScheduleMapper;
import com.backend.domain.schedule.repository.ScheduleRepository;
import com.backend.global.error.exception.ForbiddenException;
import com.backend.global.error.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
    }

    public List<ScheduleResponse> getAllManagerSchedules(String accessToken) {
        List<Schedule> schedules = scheduleRepository.findAllByActivated(true);
        return schedules.stream()
                .map(scheduleMapper::toScheduleResponse)
                .collect(Collectors.toList());
    }

    public ScheduleResponse getManagerScheduleById(Long scheduleId, String accessToken) {
        Schedule schedule = scheduleRepository.findByIdAndActivated(scheduleId, true);
        if (schedule == null) {
            throw new NotFoundException("Schedule not found.");
        }
        return scheduleMapper.toScheduleResponse(schedule);
    }
}