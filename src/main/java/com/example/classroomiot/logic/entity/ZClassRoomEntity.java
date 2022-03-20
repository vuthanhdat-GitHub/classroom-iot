package com.example.classroomiot.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zclass_rooms")
@Getter
@Setter
public class ZClassRoomEntity extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "zclass_room", fetch = FetchType.LAZY)
    private List<TimeEntity> times = new ArrayList<>();

    @OneToMany(mappedBy = "zclass_room" , fetch = FetchType.LAZY)
    private List<DeviceEntity> devices = new ArrayList<>();
}
