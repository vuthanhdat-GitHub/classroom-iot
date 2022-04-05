package com.example.classroomiot.logic.dto.output;

import com.example.classroomiot.logic.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutput{
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
