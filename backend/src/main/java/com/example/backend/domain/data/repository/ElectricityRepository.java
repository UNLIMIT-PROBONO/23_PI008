package com.example.backend.domain.data.repository;

import com.example.backend.domain.data.entity.Electricity;
import com.example.backend.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElectricityRepository extends JpaRepository<Electricity, Long> {

    @Query("SELECT AVG(e.usage) FROM Electricity e WHERE e.users.id = :userId AND e.createdAt BETWEEN :startDate AND :endDate")
    double calculateAverageUsageByUserIdAndDateRange(@Param("userId") Long userId,
                                                     @Param("startDate") String startDate,
                                                     @Param("endDate") String endDate);

    Electricity findFirstByUsersOrderByCreatedAtDesc(Users users);
    List<Electricity> findAllByUsersAndCreatedAtBetween(Users users, String startDate, String endDate);


}
