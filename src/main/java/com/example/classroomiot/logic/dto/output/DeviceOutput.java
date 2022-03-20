package com.example.classroomiot.logic.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceOutput {
    private Long id;
    private String name;
    private Integer status;
}
