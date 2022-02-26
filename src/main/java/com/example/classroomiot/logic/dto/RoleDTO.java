package com.example.classroomiot.logic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO extends AbstractDTO<RoleDTO> {
    private String name;
    private String code;
}
