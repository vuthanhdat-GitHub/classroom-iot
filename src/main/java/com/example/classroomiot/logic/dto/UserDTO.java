package com.example.classroomiot.logic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO>{
    private String fullName;
    private String username;
    private String password;
    private Integer status;
    private String email;
    private String numberPhone;
    private String workplance;
    private String address;
    private Long roleId;
    private List<RoleDTO> roles;
    private List<Long> roleIds;
}
