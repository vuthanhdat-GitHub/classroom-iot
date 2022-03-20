package com.example.classroomiot.logic.api.admin;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.DeviceDTO;
import com.example.classroomiot.logic.service.DeviceService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/device")
public class DeviceAPI {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        DeviceDTO result = deviceService.findById(id);
        return ResponseEntityBuilder.getBuilder().setDetails(result).setMessage(AppConstant.message.device.FIND_SUCCESS).build();
    }
}
