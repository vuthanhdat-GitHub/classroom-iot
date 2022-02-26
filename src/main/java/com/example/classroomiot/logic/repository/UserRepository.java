package com.example.classroomiot.logic.repository;

import com.example.classroomiot.logic.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {
    UserEntity findOneByNumberPhoneAndStatus(String numberPhone, int status);
    Optional<UserEntity> findById(Long id);
}
