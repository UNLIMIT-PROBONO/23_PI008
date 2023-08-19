package com.example.backend.domain.users.service;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.exception.ManagersNotFoundException;
import com.example.backend.domain.managers.repository.ManagerRepository;
import com.example.backend.domain.users.dto.request.UserRequestDto;
import com.example.backend.domain.users.dto.response.UserResponseDto;
import com.example.backend.domain.users.entity.Gender;
import com.example.backend.domain.users.entity.Users;
import com.example.backend.domain.users.exception.UserNotFoundException;
import com.example.backend.domain.users.mapper.UserMapper;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    private final UserMapper userMapper;

    // 유저(관리대상자) 저장
    @Transactional
    public void addUser(String adminId, UserRequestDto userRequestDto) {

        Managers manager = managerRepository.findByLoginIdAndIsActivated(adminId, true)
                .orElseThrow(ManagersNotFoundException::new);
        Gender gender = Gender.getGenderByName(userRequestDto.getGender());

        Users user = userMapper.toEntity(userRequestDto, manager, gender);
        userRepository.save(user);
    }

    // 단일 유저(관리대상자) 조회
    public UserResponseDto getUser(Long userId) {

        Users user = userRepository.findByIdAndIsActivated(userId, true)
                .orElseThrow(UserNotFoundException::new);

        return userMapper.fromEntity(user);
    }

    // 유저(관리대상자) 전체 조회
    public List<UserResponseDto> getAllUser(String loginId) {

        Managers manager = managerRepository.findByLoginIdAndIsActivated(loginId, true)
                .orElseThrow(ManagersNotFoundException::new);

        List<Users> usersList = userRepository.findAllByManagersAndIsActivated(manager, true);
        if (usersList.isEmpty()) {
            throw new UserNotFoundException();
        }
        List<UserResponseDto> userResponseDtoList = usersList.stream()
                .map(userMapper::fromEntity)
                .collect(Collectors.toList());

        return userResponseDtoList;
    }
}
