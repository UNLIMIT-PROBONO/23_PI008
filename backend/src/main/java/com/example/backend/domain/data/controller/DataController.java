package com.example.backend.domain.data.controller;

import com.example.backend.domain.data.dto.*;
import com.example.backend.domain.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    // 유저 1명별 데이터 자료 저장
    @PostMapping
    public DataResponseDto saveData(@RequestBody DataRequestDto dataRequestDto) {
        dataService.saveData(dataRequestDto);
        DataResponseDto responseDto = dataService.createResponseDto(dataRequestDto);
        return responseDto;
    }



    // 유저 리스트로 한번에 데이터 저장
    @PostMapping("/list")
    public ResponseEntity<Void> saveDataList(@RequestBody List<DataRequestDto> dataRequestDtoList) {
        dataService.saveDataList(dataRequestDtoList);
        return ResponseEntity.ok().build();
    }



    // 유저의 오늘 이용량 + 평균값 조회
    @GetMapping("/usage/{userId}")
    public ResponseEntity<UsageResponseDto> getUsage(@PathVariable Long userId) {
        try {
            UsageResponseDto usageResponseDto = dataService.getUsage(userId);
            return ResponseEntity.ok(usageResponseDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    // 유저의 일주일 평균값만 조회
    @GetMapping("/avg/{userId}")
    public ResponseEntity<AverageResponseDto> getAverageData(@PathVariable Long userId) {
        try {
            AverageResponseDto averageData = dataService.getAverageData(userId);
            return ResponseEntity.ok(averageData) ;
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    // 유저의 데이터 전체 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DataSearchResponseDto>> getUserData(@PathVariable Long userId, @RequestBody DataSearchRequestDto requestDto) {
        try {
            List<DataSearchResponseDto> responseData = dataService.getUserData(userId, requestDto.getStartDate(), requestDto.getEndDate());
            if (responseData.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(responseData);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


}