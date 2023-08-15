package com.example.backend.domain.schedule.controller;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleListResponse;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedules() {
        ScheduleListResponse listResponse = scheduleService.getAllSchedules();
        List<ScheduleResponse> responseList = listResponse.getSchedules();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        ScheduleResponse response = scheduleService.getSchedule(scheduleId);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<ScheduleResponse>> getHistory(@PathVariable Long userId) {
        List<ScheduleResponse> responseList = scheduleService.getHistory(userId);
        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> addSchedule(@RequestBody ScheduleRequest request) {
        ScheduleResponse response = scheduleService.addSchedule(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequest request
    ) {
        ScheduleResponse response = scheduleService.updateSchedule(scheduleId, request);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("Schedule deleted successfully");
    }
}