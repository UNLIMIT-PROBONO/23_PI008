package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.AverageResponseDto;
import com.example.backend.domain.data.dto.UsageResponseDto;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import com.example.backend.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UsageMapper {

    // 오늘 사용량 + 평균값 조회
    public UsageResponseDto mapEntityToDto(Call call, Electricity electricity, Water water, Users users, double callAvg, double waterAvg, double electricityAvg) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");    // 소숫점 두자리 수까지 평균값 계산

        return UsageResponseDto.builder()
                .userId(users.getId())
                .call(call.getUsage())
                .callAvg(Double.parseDouble(decimalFormat.format(callAvg)))
                .electricity(electricity.getUsage())
                .electricityAvg(Double.parseDouble(decimalFormat.format(electricityAvg)))
                .water(water.getUsage())
                .waterAvg(Double.parseDouble(decimalFormat.format(waterAvg)))
                .date(LocalDate.now().toString())
                .build();
    }


    // 평균값만 조회
    public AverageResponseDto mapToDto(Users userId, double callAvg, double electricityAvg, double waterAvg, String startDate, String endDate) {
        return AverageResponseDto.builder()
                .userId(userId.getId())
                .callAverage(callAvg)
                .electricityAverage(electricityAvg)
                .waterAverage(waterAvg)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }


}
