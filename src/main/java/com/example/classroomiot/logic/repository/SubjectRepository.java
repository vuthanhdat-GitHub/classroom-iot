package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity , Long> {
}
