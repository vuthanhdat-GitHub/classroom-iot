package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.ZClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZClassRoomRepository extends JpaRepository<ZClassRoomEntity , Long> {
}
