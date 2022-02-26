package com.example.classroomiot.logic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "times")
@Getter
@Setter
public class TimeEntity extends BaseEntity{
    @Column(name = "start_name")
    private String startName;

    @Column(name = "end_name")
    private String endName;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zclass_room_id")
    private ZClassRoomEntity zclass_room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
}
