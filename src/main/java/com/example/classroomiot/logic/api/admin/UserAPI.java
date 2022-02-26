package com.example.classroomiot.logic.api.admin;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.UserDTO;
import com.example.classroomiot.logic.service.UserService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserDTO user) {
        user = userService.save(user);
        return ResponseEntityBuilder.getBuilder().setMessage(AppConstant.message.user.SAVE_USER_SUCCESS).setDetails(user).build();
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser() {
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntityBuilder.getBuilder().setDetails(users).setMessage(AppConstant.message.user.GET_ALL_USER_SUCCESS).build();
    }
}
