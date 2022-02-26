package com.example.classroomiot.logic.repository.custom;

import com.example.classroomiot.logic.dto.output.sqlcustom.UserOutPut;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserOutPut> findUserByFocusRoleAndCreatedUser(String roleFocus , Long userIdCreated , String name, Pageable pageable);
    Long countUserByFocusRoleAndCreatedUser(String roleFocus , Long userIdCreated, String name);
}
