package com.example.classroomiot.logic.api;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.UserDTO;
import com.example.classroomiot.logic.service.UserService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api/")
public class CommonAPI {

    private final UserService userService;

    @Autowired
    public CommonAPI(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return ResponseEntityBuilder.getBuilder().setMessage(AppConstant.message.user.REGISTER_SUCCESS).build();
    }
}
