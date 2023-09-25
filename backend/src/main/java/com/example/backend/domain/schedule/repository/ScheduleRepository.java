package com.example.backend.domain.schedule.repository;

import com.example.backend.domain.schedule.entity.Schedule;
import com.example.backend.domain.managers.entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByManager(Managers manager);

    List<Schedule> findByYearAndMonth(int year, int month);
    List<Schedule> findThisWeekSchedules();

}
