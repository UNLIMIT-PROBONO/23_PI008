package com.example.backend.domain.data.service;

import com.example.backend.domain.data.dto.*;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import com.example.backend.domain.data.mapper.*;
import com.example.backend.domain.data.repository.CallRepository;
import com.example.backend.domain.data.repository.ElectricityRepository;
import com.example.backend.domain.data.repository.WaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataService {

    private final CallRepository callRepository;
    private final ElectricityRepository electricityRepository;
    private final WaterRepository waterRepository;

    private final CallMapper callMapper;
    private final ElectricityMapper electricityMapper;
    private final WaterMapper waterMapper;
    private final DataSearchMapper dataSearchMapper;
    private final UsageMapper usageMapper;


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


    // 오늘 사용량 + 일주일 평균값 조회 함수
    public UsageResponseDto getUsage(Long userId) {
        // 가장 최신값 가져오기
        Call call = callRepository.findFirstByUserIdOrderByCreatedAtDesc(userId);
        Water water = waterRepository.findFirstByUserIdOrderByCreatedAtDesc(userId);
        Electricity electricity = electricityRepository.findFirstByUserIdOrderByCreatedAtDesc(userId);

        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        int callAvg = (int) callRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        int electricityAvg = (int) electricityRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        int waterAvg = (int) waterRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));

        UsageResponseDto responseDto = usageMapper.mapEntityToDto(call, water, electricity, callAvg, waterAvg, electricityAvg);
        return responseDto;
    }



    // 유저별 일주일 평균값만 조회하는 함수
    public AverageResponseDto getAverageData(Long userId) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        double callAverage = callRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double waterAverage = waterRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double elecAverage = electricityRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));

        UsageMapper mapper = new UsageMapper();
        return mapper.mapToDto(String.valueOf(userId), (int) callAverage, (int) waterAverage, (int) elecAverage, startDate.format(formatter), endDate.format(formatter));
    }





    // 유저 데이터 조회 함수
    public List<DataSearchResponseDto> getUserData(Long userId, String startDate, String endDate) {

        List<DataSearchResponseDto> result = new ArrayList<>();

        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDateTime endDateTime = endLocalDate.plusDays(1).atStartOfDay();
        String endDateString = endDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));


        List<Call> callList = callRepository.findAllByUserIdAndCreatedAtBetween(userId, startDate, endDateString);
        List<Electricity> electricityList = electricityRepository.findAllByUserIdAndCreatedAtBetween(userId, startDate, endDateString);
        List<Water> waterList = waterRepository.findAllByUserIdAndCreatedAtBetween(userId, startDate, endDateString);

        Map<String, DataSearchResponseDto> resultMap = new HashMap<>();

        for (Call call : callList) {
            String date = call.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(userId, date, 0, 0, 0));
            dto.setCall(call.getUsage());
            resultMap.put(date, dto);
        }

        for (Electricity electricity : electricityList) {
            String date = electricity.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(userId, date, 0, 0, 0));
            dto.setElectricity(electricity.getUsage());
            resultMap.put(date, dto);
        }

        for (Water water : waterList) {
            String date = water.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(userId, date, 0, 0, 0));
            dto.setWater(water.getUsage());
            resultMap.put(date, dto);
        }

        result.addAll(resultMap.values());
        return result;
    }



}
