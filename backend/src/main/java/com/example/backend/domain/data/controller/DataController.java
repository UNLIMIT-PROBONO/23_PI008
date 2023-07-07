package com.example.backend.domain.data.controller;

import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import com.example.backend.domain.data.mapper.CallMapper;
import com.example.backend.domain.data.mapper.ElectricityMapper;
import com.example.backend.domain.data.mapper.WaterMapper;
import com.example.backend.domain.data.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;
    private final CallMapper callMapper;
    private final ElectricityMapper electricityMapper;
    private final WaterMapper waterMapper;

    @PostMapping
    public DataResponseDto saveData(@RequestBody DataRequestDto dataRequestDto) {
        dataService.saveData(dataRequestDto);

        // 저장 후 응답으로 반환할 DataResponseDto 생성
        DataResponseDto responseDto = DataResponseDto.builder()
                .userId(String.valueOf(dataRequestDto.getUserId()))
                .callData(dataRequestDto.getCall())
                .electricityData(dataRequestDto.getElectricity())
                .waterData(dataRequestDto.getWater())
                .date(new Date())
                .build();

        return responseDto;
    }


    @PostMapping("/save")
    public ResponseEntity<Void> saveDataList(@RequestBody List<DataRequestDto> dataRequestDtoList) {
        dataService.saveDataList(dataRequestDtoList);
        return ResponseEntity.ok().build();
    }

}
