package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WaterRepository extends JpaRepository<Water, Long> {

    @Query("SELECT AVG(w.usage) FROM Water w WHERE w.userId = :userId AND w.createdAt BETWEEN :startDate AND :endDate")
    double calculateAverageUsageByUserIdAndDateRange(@Param("userId") Long userId,
                                                     @Param("startDate") String startDate,
                                                     @Param("endDate") String endDate);


    Water findByUserId(Long userId);

    Water findFirstByUserIdOrderByCreatedAtDesc(Long userId);

    List<Water> findAllByUserIdAndCreatedAtBetween(Long userId, String startDate, String endDate);
}
