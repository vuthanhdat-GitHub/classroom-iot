package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.logic.converter.Converter;
import com.example.classroomiot.logic.dto.DeviceDTO;
import com.example.classroomiot.logic.entity.DeviceEntity;
import com.example.classroomiot.logic.repository.DeviceRepository;
import com.example.classroomiot.logic.service.DeviceService;
import com.example.classroomiot.logic.utils.CommonUtils;
import com.example.classroomiot.logic.utils.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public DeviceDTO findById(Long id) {
        Optional<DeviceEntity> device = deviceRepository.findById(id);
        if (Objects.isNull(device)) {
            throw new CustomException("device is null", CommonUtils.putError("deviceId", "ERR_0034"));
        }
        return Converter.toModel(device, DeviceDTO.class);
    }
}
