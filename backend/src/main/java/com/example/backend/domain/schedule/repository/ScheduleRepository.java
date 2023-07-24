package com.example.backend.domain.schedule.repository;

import com.example.backend.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.endDate >= CURRENT_DATE AND (:userId IS NULL OR s.userId = :userId) ORDER BY s.startDate DESC")
    List<Schedule> returnAfterToday(@Param("userId") Long userId);

    List<Schedule> findByUserId(Long userId);

    Schedule findById(Long scheduleId);
}

