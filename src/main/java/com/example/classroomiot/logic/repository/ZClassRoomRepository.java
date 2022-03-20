package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.ZClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZClassRoomRepository extends JpaRepository<ZClassRoomEntity , Long> {
    Optional<ZClassRoomEntity> findById(Long id);
}
