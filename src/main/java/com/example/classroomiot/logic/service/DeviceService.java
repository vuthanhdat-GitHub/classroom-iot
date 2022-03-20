package com.example.classroomiot.logic.service;

import com.example.classroomiot.logic.dto.DeviceDTO;

public interface DeviceService {
    DeviceDTO findById(Long id);
}
