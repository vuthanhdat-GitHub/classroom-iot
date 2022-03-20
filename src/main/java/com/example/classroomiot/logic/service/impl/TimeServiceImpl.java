package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.logic.converter.Converter;
import com.example.classroomiot.logic.dto.TimeDTO;
import com.example.classroomiot.logic.entity.TimeEntity;
import com.example.classroomiot.logic.repository.TimeRepository;
import com.example.classroomiot.logic.service.TimeService;
import com.example.classroomiot.logic.utils.CommonUtils;
import com.example.classroomiot.logic.utils.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public TimeDTO findByStartAt(String startAt) {
        Optional<TimeEntity> time = Optional.ofNullable(timeRepository.findByStartAt(startAt));
        if (Objects.isNull(time)) {
            throw new CustomException("start at is null", CommonUtils.putError("timeId", "ERR_0034"));
        }
        return Converter.toModel(time, TimeDTO.class);
    }

    @Override
    public TimeDTO findByEndAt(String endAt) {
        Optional<TimeEntity> time = Optional.ofNullable(timeRepository.findByStartAt(endAt));
        if (Objects.isNull(time)) {
            throw new CustomException("end at is null", CommonUtils.putError("timeId", "ERR_0034"));
        }
        return Converter.toModel(time, TimeDTO.class);
    }
}
