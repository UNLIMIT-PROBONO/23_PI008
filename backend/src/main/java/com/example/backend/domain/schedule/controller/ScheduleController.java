package com.example.backend.domain.schedule.controller;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody ScheduleRequest request) {
        ScheduleResponse response = scheduleService.createSchedule(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        ScheduleResponse response = scheduleService.getSchedule(scheduleId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedules() {
        List<ScheduleResponse> responseList = scheduleService.getAllSchedules();
        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequest request) {
        ScheduleResponse response = scheduleService.updateSchedule(scheduleId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().build();
    }
}
