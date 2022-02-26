package com.example.classroomiot.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class SubjectEntity extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<TimeEntity> times = new ArrayList<TimeEntity>();
}
