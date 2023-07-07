package com.example.backend.domain.data.service;

import com.example.backend.domain.data.dto.DataRequestDto;
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
        callRepository.save(call);

        Electricity electricity = electricityMapper.toEntity(dataRequestDto);
        electricityRepository.save(electricity);

        Water water = waterMapper.toEntity(dataRequestDto);
        waterRepository.save(water);

    }

    // 여러명의 유저 리스트로 한꺼번에 저장
    @Transactional
    public void saveDataList(List<DataRequestDto> dataRequestDtoList) {
        for (DataRequestDto dataRequestDto : dataRequestDtoList) {
            Long userId = dataRequestDto.getUserId();

            Call call = callMapper.toEntity(dataRequestDto);
            callRepository.save(call);

            Electricity electricity = electricityMapper.toEntity(dataRequestDto);
            electricityRepository.save(electricity);

            Water water = waterMapper.toEntity(dataRequestDto);
            waterRepository.save(water);
        }
    }


}
