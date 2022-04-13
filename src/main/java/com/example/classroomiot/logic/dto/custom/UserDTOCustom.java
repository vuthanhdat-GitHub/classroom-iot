package com.example.classroomiot.logic.dto.custom;

import com.example.classroomiot.logic.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOCustom extends AbstractDTO<UserDTOCustom> {
    private String fullName;
    private String numberPhone;
}
