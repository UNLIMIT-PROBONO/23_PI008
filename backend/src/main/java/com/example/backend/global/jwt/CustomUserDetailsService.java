package com.example.backend.global.jwt;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.managers.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Managers managerEntity = managerRepository.findByLoginId(username).orElseThrow(
                () -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다.")
        );
        return new CustomUserDetails(managerEntity);
    }
}

