package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.AverageResponseDto;
import com.example.backend.domain.data.dto.UsageResponseDto;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UsageMapper {

    // 오늘 사용량 + 평균값 조회
    public UsageResponseDto mapEntityToDto(Call call, Water water, Electricity electricity, int callAvg, int waterAvg, int electricityAvg) {
        UsageResponseDto usageResponseDto = new UsageResponseDto();
        usageResponseDto.setUserId(call.getUserId());
        usageResponseDto.setCall(call.getUsage());
        usageResponseDto.setCallAvg(callAvg);
        usageResponseDto.setWater(water.getUsage());
        usageResponseDto.setWaterAvg(waterAvg);
        usageResponseDto.setElec(electricity.getUsage());
        usageResponseDto.setElecAvg(electricityAvg);
        usageResponseDto.setDate(LocalDate.now().toString());
        return usageResponseDto;
    }



    // 평균값만 조회
    public AverageResponseDto mapToDto(String userId, int callAverage, int waterAverage, int elecAverage, String startDate, String endDate) {
        return AverageResponseDto.builder()
                .userId(userId)
                .callAverage(callAverage)
                .waterAverage(waterAverage)
                .elecAverage(elecAverage)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }


}
