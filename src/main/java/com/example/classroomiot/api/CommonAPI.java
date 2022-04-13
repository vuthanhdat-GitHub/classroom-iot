package com.example.classroomiot.api;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.UserDTO;
import com.example.classroomiot.logic.dto.custom.UserDTOCustom;
import com.example.classroomiot.logic.service.DeviceService;
import com.example.classroomiot.logic.service.UserService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api")
public class CommonAPI {

    private final UserService userService;
    private final DeviceService deviceService;

    @Autowired
    public CommonAPI(UserService userService
            , DeviceService deviceService) {
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return ResponseEntityBuilder.getBuilder().setMessage(AppConstant.message.user.REGISTER_SUCCESS).build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserDTO user) {
        user = userService.save(user);
        return ResponseEntityBuilder.getBuilder().setMessage(AppConstant.message.user.SAVE_USER_SUCCESS).setDetails(user).build();
    }
}
