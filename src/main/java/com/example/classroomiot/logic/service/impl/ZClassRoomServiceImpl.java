package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.logic.converter.Converter;
import com.example.classroomiot.logic.dto.ZClassRoomDTO;
import com.example.classroomiot.logic.entity.ZClassRoomEntity;
import com.example.classroomiot.logic.repository.ZClassRoomRepository;
import com.example.classroomiot.logic.service.ZClassRoomService;
import com.example.classroomiot.logic.utils.CommonUtils;
import com.example.classroomiot.logic.utils.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ZClassRoomServiceImpl implements ZClassRoomService {

    @Autowired
    private ZClassRoomRepository zClassRoomRepository;

    @Override
    public ZClassRoomDTO findById(Long id) {
        Optional<ZClassRoomEntity> zClassRoom = zClassRoomRepository.findById(id);
        if (Objects.isNull(zClassRoom)) {
            throw new CustomException("class room is null", CommonUtils.putError("zClassRoomId", "ERR_0034"));
        }
        return Converter.toModel(zClassRoom, ZClassRoomDTO.class);
    }
}
