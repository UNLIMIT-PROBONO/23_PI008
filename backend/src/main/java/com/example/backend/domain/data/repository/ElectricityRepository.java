package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Electricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ElectricityRepository extends JpaRepository<Electricity, Long> {

    @Query("SELECT AVG(e.usage) FROM Electricity e WHERE e.userId = :userId AND e.createdAt BETWEEN :startDate AND :endDate")
    double calculateAverageUsageByUserIdAndDateRange(@Param("userId") Long userId,
                                                     @Param("startDate") String startDate,
                                                     @Param("endDate") String endDate);



}
