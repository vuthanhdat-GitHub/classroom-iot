package com.example.classroomiot.logic.api.admin;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.ZClassRoomDTO;
import com.example.classroomiot.logic.service.ZClassRoomService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/zclassroom")
public class ZClassRoomAPI {

    @Autowired
    private ZClassRoomService zClassRoomService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        ZClassRoomDTO result = zClassRoomService.findById(id);
        return ResponseEntityBuilder.getBuilder().setDetails(result).setMessage(AppConstant.message.zclassRoom.GET_SUCCESS).build();
    }
}
