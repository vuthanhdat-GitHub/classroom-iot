package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity , Long> {
    List<RoleEntity> findAllByCode(String code);
    List<RoleEntity> findAllByIdIn(List<Long> roleIds);
}
