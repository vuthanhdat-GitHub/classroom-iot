package com.example.classroomiot.logic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDTO extends AbstractDTO<DeviceDTO>{
    private String name;
    private Integer status;
}
