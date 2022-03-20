package com.example.classroomiot.logic.api.admin;

import com.example.classroomiot.logic.service.FireBaseService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.firebase.database.DataSnapshot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class FirebaseAPI {

    @Autowired
    private FireBaseService fireBaseService;

    @PostMapping("/api/execute-firebase")
    public ResponseEntity<?> demoFireBase(@RequestParam Map<String, String> model) {
        fireBaseService.putFireBase(model);
        return ResponseEntityBuilder.getBuilder()
                .setMessage("SUCCESS")
                .build();
    }
}
