package com.example.classroomiot.logic.repository.custom;

import com.example.classroomiot.logic.dto.output.UserOutput;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserOutput> findUserByFocusRoleAndCreatedUser(String roleFocus , Long userIdCreated , String name, Pageable pageable);
}
