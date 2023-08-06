package com.example.backend.domain.schedule.controller;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

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

    @DeleteMapping
    public ResponseEntity<Void> deleteSchedule(@RequestBody List<Long> scheduleIdList) {
        scheduleService.deleteSchedule(scheduleIdList);
        return ResponseEntity.ok().build();
    }
}
