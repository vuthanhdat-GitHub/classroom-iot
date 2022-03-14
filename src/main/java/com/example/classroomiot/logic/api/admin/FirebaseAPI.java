package com.example.classroomiot.logic.api.admin;

import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class FirebaseAPI {

    @Autowired
    private FirebaseDatabase firebaseDatabase;

    @PostMapping("/api/execute-firebase")
    public ResponseEntity<?> demoFireBase(@RequestBody Map<String, String> model) {
        DatabaseReference startAt = firebaseDatabase.getReference("rooms/room1/device1/startAt");
        startAt.setValueAsync("13/03/2022 08:00:00");
        log.info("success");
        return ResponseEntityBuilder.getBuilder()
                .setMessage("SUCCESS")
                .build();
    }
}
