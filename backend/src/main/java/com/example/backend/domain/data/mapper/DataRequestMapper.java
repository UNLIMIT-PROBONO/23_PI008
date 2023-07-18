package com.example.backend.domain.data.mapper;

import com.example.backend.domain.data.dto.DataRequestDto;
import com.example.backend.domain.data.entity.Call;
import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.data.entity.Water;
import com.example.backend.domain.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
@RequiredArgsConstructor
public class DataRequestMapper {

    public Call toCallEntity(DataRequestDto dto, Users users) {
        Call call = Call.builder()
                .users(users)
                .usage(dto.getCall())
                .build();
        call.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        return call;
    }

    public Electricity toElectricityEntity(DataRequestDto dto, Users users) {
        Electricity electricity = Electricity.builder()
                .users(users)
                .usage(dto.getElectricity())
                .build();
        electricity.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        return electricity;
    }

    public Water toWaterEntity(DataRequestDto dto, Users users) {
        Water water = Water.builder()
                .users(users)
                .usage(dto.getWater())
                .build();
        water.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
        return water;
    }

}
