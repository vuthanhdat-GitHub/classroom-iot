package com.example.classroomiot.logic.service;

import com.example.classroomiot.logic.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO user);
    UserDTO save(UserDTO user);
    List<UserDTO> getAllUser();
    UserDTO findById(Long id);
}
