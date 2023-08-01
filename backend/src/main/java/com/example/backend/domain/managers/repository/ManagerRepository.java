package com.example.backend.domain.managers.repository;

import com.example.backend.domain.managers.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Managers, Long> {

    Optional<Managers> findByLoginIdAndIsActivated(String loginId, boolean status);

    boolean existsByLoginId(String loginId);
}