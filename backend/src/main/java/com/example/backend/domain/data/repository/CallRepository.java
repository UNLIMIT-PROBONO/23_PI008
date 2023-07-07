package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Long> {
}
