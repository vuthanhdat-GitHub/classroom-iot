package com.example.classroomiot.logic.entity;

import com.example.classroomiot.logic.dto.output.sqlcustom.UserOutPut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@SqlResultSetMapping(name = "findAllUserByCondition" , classes = {
        @ConstructorResult(targetClass = UserOutPut.class ,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "createddate", type = Date.class),
                        @ColumnResult(name = "modifieddate", type = Date.class),
                        @ColumnResult(name = "createdby", type = String.class),
                        @ColumnResult(name = "modifiedby", type = String.class),
                        @ColumnResult(name = "fullname", type = String.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "gender", type = String.class),
                        @ColumnResult(name = "status", type = Integer.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "numberphone", type = String.class),
                        @ColumnResult(name = "workplance", type = String.class),
                        @ColumnResult(name = "address", type = String.class)
                })
})
public class UserEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "status")
    private Integer status;

    @Column(name = "email")
    private String email;

    @Column(name = "numberphone")
    private String numberPhone;

    @Column(name = "workplance")
    private String workplance;

    @Column(name = "address")
    private String address;

    @Column(name = "user_id_created")
    private Long userIdCreated;

    @Column(name = "focus_role")
    private String focusRole;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();
}
