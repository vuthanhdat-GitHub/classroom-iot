package com.example.classroomiot.logic.dto.output.sqlcustom;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOutPut {
    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private String fullName;
    private String username;
    private String gender;
    private Integer status;
    private String email;
    private String numberPhone;
    private String workplance;
    private String address;

    public UserOutPut() {
    }

    public UserOutPut(Long id, Date createdDate, Date modifiedDate, String createdBy, String modifiedBy, String fullName, String username, String gender, Integer status, String email, String numberPhone, String workplance, String address) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.fullName = fullName;
        this.username = username;
        this.gender = gender;
        this.status = status;
        this.email = email;
        this.numberPhone = numberPhone;
        this.workplance = workplance;
        this.address = address;
    }
}
