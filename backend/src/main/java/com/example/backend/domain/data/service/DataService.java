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
import com.example.backend.domain.users.entity.Users;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataService {

    private final UserRepository userRepository;
    private final CallRepository callRepository;
    private final ElectricityRepository electricityRepository;
    private final WaterRepository waterRepository;

    private final DataRequestMapper dataRequestMapper;
    private final DataSearchMapper dataSearchMapper;
    private final UsageMapper usageMapper;


    // 유저 1명의 데이터 저장
    @Transactional
    public void saveData(DataRequestDto dataRequestDto) {
        Optional<Users> optionalUsers = userRepository.findById(dataRequestDto.getUserId());

        if (optionalUsers.isPresent()) {
            Users findUsers = optionalUsers.get();

            Call call = dataRequestMapper.toCallEntity(dataRequestDto, findUsers);
            call.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            callRepository.save(call);

            Electricity electricity = dataRequestMapper.toElectricityEntity(dataRequestDto, findUsers);
            electricity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            electricityRepository.save(electricity);

            Water water = dataRequestMapper.toWaterEntity(dataRequestDto, findUsers);
            water.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            waterRepository.save(water);

        } else {
            // 사용자를 찾지 못한 경우에 대한 처리
            throw new IllegalArgumentException("User not found");
        }
    }
    public DataResponseDto createResponseDto(DataRequestDto dataRequestDto) {
        // 응답 DTO 생성 로직 구현
        String createdAtString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        return DataResponseDto.builder()
                .userId(dataRequestDto.getUserId())
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
            Optional<Users> optionalUsers = userRepository.findById(dataRequestDto.getUserId());

            if (optionalUsers.isPresent()) {
                Users findUsers = optionalUsers.get();

                Call call = dataRequestMapper.toCallEntity(dataRequestDto, findUsers);
                call.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
                callRepository.save(call);

                Electricity electricity = dataRequestMapper.toElectricityEntity(dataRequestDto, findUsers);
                electricity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
                electricityRepository.save(electricity);

                Water water = dataRequestMapper.toWaterEntity(dataRequestDto, findUsers);
                water.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
                waterRepository.save(water);
            } else {
                // 사용자를 찾지 못한 경우에 대한 처리
                throw new IllegalArgumentException("User not found");
            }
        }
    }



    // 오늘 사용량 + 일주일 평균값 조회 함수
    @Transactional
    public UsageResponseDto getUsage(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);     // 해당 사용자를 찾을 수 없는 경우

    @Transactional
    public AverageResponseDto calculateAverageData(Long userId) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        // 가장 최신값 가져오기
        Call call = callRepository.findFirstByUsersOrderByCreatedAtDesc(user);
        Water water = waterRepository.findFirstByUsersOrderByCreatedAtDesc(user);
        Electricity electricity = electricityRepository.findFirstByUsersOrderByCreatedAtDesc(user);

        // 평균값 구하기
        double callAvg = callRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double electricityAvg = electricityRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double waterAvg = waterRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));

        return usageMapper.mapEntityToDto(call, electricity, water, user, callAvg, waterAvg, electricityAvg);
    }



    // 유저별 일주일 평균값만 조회하는 함수
    @Transactional
    public AverageResponseDto getAverageData(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);  // 해당 사용자를 찾을 수 없는 경우 예외

        LocalDateTime endDate = LocalDateTime.now();     // 현재 날짜
        LocalDateTime startDate = endDate.minusDays(7);  // 시작 날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        double callAverage = callRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double elecAverage = electricityRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));
        double waterAverage = waterRepository.calculateAverageUsageByUserIdAndDateRange(userId, startDate.format(formatter), endDate.format(formatter));

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        callAverage = Double.parseDouble(decimalFormat.format(callAverage));
        elecAverage = Double.parseDouble(decimalFormat.format(elecAverage));
        waterAverage = Double.parseDouble(decimalFormat.format(waterAverage));

        return usageMapper.mapToDto( user, callAverage, elecAverage, waterAverage, startDate.format(formatter), endDate.format(formatter));
    }



    // 유저 데이터 조회 함수
    @Transactional
    public List<DataSearchResponseDto> getUserData(Long userId, String startDate, String endDate) {
        Users user = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new); // 해당 사용자를 찾을 수 없는 경우 예외 던지기

        List<DataSearchResponseDto> result = new ArrayList<>();

        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDateTime endDateTime = endLocalDate.plusDays(1).atStartOfDay();
        String endDateString = endDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));


        List<Call> callList = callRepository.findAllByUsersAndCreatedAtBetween(user, startDate, endDateString);
        List<Electricity> electricityList = electricityRepository.findAllByUsersAndCreatedAtBetween(user, startDate, endDateString);
        List<Water> waterList = waterRepository.findAllByUsersAndCreatedAtBetween(user, startDate, endDateString);

        Map<String, DataSearchResponseDto> resultMap = new HashMap<>();

        for (Call call : callList) {
            String date = call.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(user, date, 0, 0, 0));
            dto.setCall(call.getUsage());
            resultMap.put(date, dto);
        }
        for (Electricity electricity : electricityList) {
            String date = electricity.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(user, date, 0, 0, 0));
            dto.setElectricity(electricity.getUsage());
            resultMap.put(date, dto);
        }
        for (Water water : waterList) {
            String date = water.getCreatedAt().substring(0, 10);
            DataSearchResponseDto dto = resultMap.getOrDefault(date, dataSearchMapper.toDto(user, date, 0, 0, 0));
            dto.setWater(water.getUsage());
            resultMap.put(date, dto);
        }
        result.addAll(resultMap.values());
        return result;
    }



}
