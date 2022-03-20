package com.example.classroomiot.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "devices")
@Getter
@Setter
public class DeviceEntity extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zclass_room_id")
    private ZClassRoomEntity zclass_room;
}
