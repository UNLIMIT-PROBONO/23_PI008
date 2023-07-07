package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Electricity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricityRepository extends JpaRepository<Electricity, Long> {
}
