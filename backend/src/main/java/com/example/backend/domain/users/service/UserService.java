package com.example.backend.domain.users.service;

import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.entity.Users;
import com.example.backend.domain.users.mapper.UserMapper;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    private final UserMapper userMapper;


    // 유저(관리대상자) 저장
    @Transactional
    public Users addUser(UserRequestDto userRequestDto) {
        Users user = userMapper.toEntity(userRequestDto);
        return userRepository.save(user);
    }


}
