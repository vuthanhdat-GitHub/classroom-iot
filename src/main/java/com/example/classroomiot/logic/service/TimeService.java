package com.example.classroomiot.logic.service;

import com.example.classroomiot.logic.dto.TimeDTO;

public interface TimeService {
    TimeDTO findByStartAt(String startAt);
    TimeDTO findByEndAt(String  endAt);
}
