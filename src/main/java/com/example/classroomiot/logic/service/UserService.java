package com.example.classroomiot.logic.service;

import com.example.classroomiot.logic.dto.UserDTO;
import com.example.classroomiot.logic.dto.output.sqlcustom.UserOutPut;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO user);
    UserDTO save(UserDTO user);
    List<UserDTO> getAllUser();
    List<UserOutPut> getAllUserByCondition(Pageable pageable);
    List<UserOutPut> getAllUserByCondition(Pageable pageable, String name);
    UserDTO findById(Long id);
}
