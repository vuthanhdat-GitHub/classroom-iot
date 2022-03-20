package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.logic.dto.TimeDTO;
import com.example.classroomiot.logic.entity.TimeEntity;
import com.example.classroomiot.logic.entity.ZClassRoomEntity;
import com.example.classroomiot.logic.repository.TimeRepository;
import com.example.classroomiot.logic.repository.ZClassRoomRepository;
import com.example.classroomiot.logic.service.FireBaseService;
import com.example.classroomiot.logic.service.TimeService;
import com.example.classroomiot.logic.service.ZClassRoomService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class FireBaseServiceImpl implements FireBaseService {

    @Autowired
    private FirebaseDatabase firebaseDatabase;
    @Autowired
    private ZClassRoomRepository zClassRoomRepository;


    @Override
    public void putFireBase(Map<String, String> map) {
        log.info(map.get("1"));
        log.info(map.get("startAt"));
        log.info(map.get("endAt"));
        if (map.get("1") != null) {
            ZClassRoomEntity entity = zClassRoomRepository.findById(Long.parseLong(map.get("1"))).orElse(null);
            if (Objects.nonNull(entity)) {
                changeDataToFireBase(map.get("1") + "/endAt", map.get("endAt"));
                changeDataToFireBase(map.get("1") + "/startAt", map.get("startAt"));
            }
        }
    }

    private void changeDataToFireBase(String pathRoom, String data) {
        String path = String.format("rooms/%s", pathRoom);
        DatabaseReference reference = firebaseDatabase.getReference(path);
        reference.setValueAsync(data);
    }
}
