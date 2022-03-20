package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity , Long> {
    TimeEntity findByStartAt(String startAt);
    TimeEntity findByEndAt(String endAt);
}
