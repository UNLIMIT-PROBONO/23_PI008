package com.example.backend.domain.data.service;

import com.example.backend.domain.data.dto.AverageRequestDto;
import com.example.backend.domain.data.dto.AverageResponseDto;
import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.dto.DataResponseDto;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import com.example.backend.domain.data.mapper.CallMapper;
import com.example.backend.domain.data.mapper.ElectricityMapper;
import com.example.backend.domain.data.mapper.WaterMapper;
import com.example.backend.domain.data.repository.CallRepository;
import com.example.backend.domain.data.repository.ElectricityRepository;
import com.example.backend.domain.data.repository.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final CallRepository callRepository;
    private final ElectricityRepository electricityRepository;
    private final WaterRepository waterRepository;

    private final CallMapper callMapper;
    private final ElectricityMapper electricityMapper;
    private final WaterMapper waterMapper;


    // 유저 1명의 데이터 저장
    @Transactional
    public void saveData(DataRequestDto dataRequestDto) {
        Long userId = dataRequestDto.getUserId();

        Call call = callMapper.toEntity(dataRequestDto);
        call.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        callRepository.save(call);

        Electricity electricity = electricityMapper.toEntity(dataRequestDto);
        electricity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        electricityRepository.save(electricity);

        Water water = waterMapper.toEntity(dataRequestDto);
        water.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        waterRepository.save(water);
    }

    public DataResponseDto createResponseDto(DataRequestDto dataRequestDto) {
        // 응답 DTO 생성 로직 구현
        String createdAtString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        return DataResponseDto.builder()
                .userId(String.valueOf(dataRequestDto.getUserId()))
                .callData(dataRequestDto.getCall())
                .electricityData(dataRequestDto.getElectricity())
                .waterData(dataRequestDto.getWater())
                .createdAt(createdAtString)
                .build();
    }




    // 여러명의 유저 리스트로 한꺼번에 저장
    @Transactional
    public void saveDataList(List<DataRequestDto> dataRequestDtoList) {
        for (DataRequestDto dataRequestDto : dataRequestDtoList) {
            Long userId = dataRequestDto.getUserId();

            Call call = callMapper.toEntity(dataRequestDto);
            call.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            callRepository.save(call);

            Electricity electricity = electricityMapper.toEntity(dataRequestDto);
            electricity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            electricityRepository.save(electricity);

            Water water = waterMapper.toEntity(dataRequestDto);
            water.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            waterRepository.save(water);
        }
    }



    @Transactional
    public AverageResponseDto calculateAverageData(Long userId) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        double callAverage = callRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double electricityAverage = electricityRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double waterAverage = waterRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));

        return AverageResponseDto.builder()
                .userId(String.valueOf(userId))
                .callAverage(callAverage)
                .electricityAverage(electricityAverage)
                .waterAverage(waterAverage)
                .startDate(startDate.format(formatter))
                .endDate(endDate.format(formatter))
                .build();
    }




}
