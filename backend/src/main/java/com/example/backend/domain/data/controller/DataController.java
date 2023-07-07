package com.example.backend.domain.data.controller;

import com.example.backend.domain.data.dto.AverageRequestDto;
import com.example.backend.domain.data.dto.AverageResponseDto;
import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.mapper.CallMapper;
import com.example.backend.domain.data.mapper.ElectricityMapper;
import com.example.backend.domain.data.mapper.WaterMapper;
import com.example.backend.domain.data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;
    private final CallMapper callMapper;
    private final ElectricityMapper electricityMapper;
    private final WaterMapper waterMapper;

    // 유저 1명별 데이터 자료 저장
    @PostMapping
    public DataResponseDto saveData(@RequestBody DataRequestDto dataRequestDto) {
        // 데이터 저장
        dataService.saveData(dataRequestDto);

        // 저장 후 응답으로 반환할 DataResponseDto 생성
        DataResponseDto responseDto = dataService.createResponseDto(dataRequestDto);

        return responseDto;
    }





    // 유저 리스트로 한번에 데이터 저장
    @PostMapping("/list")
    public ResponseEntity<Void> saveDataList(@RequestBody List<DataRequestDto> dataRequestDtoList) {
        dataService.saveDataList(dataRequestDtoList);
        return ResponseEntity.ok().build();
    }


    // 유저별 평균값 조회
    @GetMapping("/{userId}")
    public ResponseEntity<AverageResponseDto> getAverageData(@PathVariable Long userId) { // AverageRequestDto 대신 AverageResponseDto로 수정
        AverageResponseDto averageData = dataService.calculateAverageData(userId);
        return ResponseEntity.ok(averageData);
    }



}
