package com.example.classroomiot.api.admin;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.TimeDTO;
import com.example.classroomiot.logic.service.TimeService;
import com.example.classroomiot.logic.utils.response.ResponseEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/device")
public class TimeAPI {

    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/{startAt}", method = RequestMethod.GET)
    public ResponseEntity<?> findStartAt(@PathVariable("startAt") String  startAt) {
        TimeDTO result = timeService.findByStartAt(startAt);
        return ResponseEntityBuilder.getBuilder().setDetails(result).setMessage(AppConstant.message.time.GET_START_AT_SUCCESS).build();
    }

    @RequestMapping(value = "/{endtAt}", method = RequestMethod.GET)
    public ResponseEntity<?> findEndAt(@PathVariable("endtAt") String  endAt) {
        TimeDTO result = timeService.findByStartAt(endAt);
        return ResponseEntityBuilder.getBuilder().setDetails(result).setMessage(AppConstant.message.time.GET_END_AT_SUCCESS).build();
    }
}
