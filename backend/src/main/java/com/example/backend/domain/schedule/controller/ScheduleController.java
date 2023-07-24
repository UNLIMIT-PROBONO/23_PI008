package com.example.backend.domain.schedule.controller;

import com.example.backend.domain.schedule.dto.request.ScheduleRequest;
import com.example.backend.domain.schedule.dto.response.ScheduleResponse;
import com.example.backend.domain.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/returnAfterToday")
    public ResponseEntity<List<ScheduleResponse>> returnAfterToday(@RequestHeader("access_token") String accessToken,
                                                                   @RequestParam(required = false) Long userId) {
        List<ScheduleResponse> schedules = scheduleService.returnAfterToday(accessToken, userId);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getSchedule(@RequestHeader("access_token") String accessToken,
                                                        @PathVariable Long scheduleId) {
        ScheduleResponse schedule = scheduleService.getSchedule(accessToken, scheduleId);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping("/history")
    public ResponseEntity<List<ScheduleResponse>> getHistory(@RequestHeader("access_token") String accessToken,
                                                             @RequestParam Long userId) {
        List<ScheduleResponse> schedules = scheduleService.getHistory(accessToken, userId);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> addSchedule(@RequestHeader("access_token") String accessToken,
                                                        @RequestBody ScheduleRequest request) {
        ScheduleResponse schedule = scheduleService.addSchedule(accessToken, request);
        return ResponseEntity.ok(schedule);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(@RequestHeader("access_token") String accessToken,
                                                           @PathVariable Long scheduleId,
                                                           @RequestBody ScheduleRequest request) {
        ScheduleResponse schedule = scheduleService.updateSchedule(accessToken, scheduleId, request);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@RequestHeader("access_token") String accessToken,
                                               @PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(accessToken, scheduleId);
        return ResponseEntity.noContent().build();
    }
}
