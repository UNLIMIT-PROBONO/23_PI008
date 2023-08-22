package com.example.backend.domain.users.repository;

import com.example.backend.domain.managers.entity.Managers;
import com.example.backend.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByIdAndIsActivated(Long Id, boolean status);

    List<Users> findAllByManagersAndIsActivated(Managers manager, boolean status);
}