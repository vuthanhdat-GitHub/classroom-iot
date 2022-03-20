package com.example.classroomiot.logic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TimeDTO extends AbstractDTO<TimeDTO>{
    private String startName;
    private String endName;
    private String startAt;
    private String endAt;
}
