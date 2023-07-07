package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CallRepository extends JpaRepository<Call, Long> {
    @Query("SELECT AVG(c.usage) FROM Call c WHERE c.userId = :userId AND c.createdAt BETWEEN :startDate AND :endDate")
    double calculateAverageUsageByUserIdAndDateRange(@Param("userId") Long userId,
                                                     @Param("startDate") String startDate,
                                                     @Param("endDate") String endDate);

}
