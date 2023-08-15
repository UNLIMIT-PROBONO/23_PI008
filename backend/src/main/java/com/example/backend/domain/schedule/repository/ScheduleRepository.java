package com.example.backend.domain.schedule.repository;

import com.example.backend.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUserId(Long userId);

    void deleteAllByScheduleIdIn(List<Long> scheduleIdList);
}