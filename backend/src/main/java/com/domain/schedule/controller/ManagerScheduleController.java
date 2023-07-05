package com.backend.domain.schedule.controller;

import com.backend.domain.schedule.dto.response.ScheduleResponse;
import com.backend.domain.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ManagerScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ManagerScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllManagerSchedules(HttpServletRequest request) {
        String accessToken = getAccessTokenFromCookie(request);
        List<ScheduleResponse> schedules = scheduleService.getAllManagerSchedules(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getManagerScheduleById(
            @PathVariable("scheduleId") Long scheduleId, HttpServletRequest request) {
        String accessToken = getAccessTokenFromCookie(request);
        ScheduleResponse schedule = scheduleService.getManagerScheduleById(scheduleId, accessToken);
        if (schedule != null) {
            return ResponseEntity.status(HttpStatus.OK).body(schedule);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private String getAccessTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("accessToken")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}