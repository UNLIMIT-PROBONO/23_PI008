package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Water;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterRepository extends JpaRepository<Water, Long> {
}
