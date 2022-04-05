package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.converter.Converter;
import com.example.classroomiot.logic.dto.UserDTO;
import com.example.classroomiot.logic.entity.RoleEntity;
import com.example.classroomiot.logic.entity.UserEntity;
import com.example.classroomiot.logic.repository.RoleRepository;
import com.example.classroomiot.logic.repository.UserRepository;
import com.example.classroomiot.logic.service.UserService;
import com.example.classroomiot.logic.utils.CommonUtils;
import com.example.classroomiot.logic.utils.JwtTokenUtils;
import com.example.classroomiot.logic.utils.SecurityUtils;
import com.example.classroomiot.logic.utils.error.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String ACTION = "REGISTER";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;


    @Override
    @Transactional
    public UserDTO register(UserDTO user) {
        validateSaveUser(user, ACTION);
        UserEntity entity = Converter.toModel(user, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setRoles(roleRepository.findAllByCode(AppConstant.role.ROLE_ADMIN));
        entity = userRepository.save(entity);
        return Converter.toModel(entity, UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO user) {
        validateSaveUser(user, "");
        List<RoleEntity> roles = roleRepository.findAllByIdIn(user.getRoleIds());
        UserEntity entity = Converter.toModel(user, UserEntity.class);
        entity.setRoles(roles);
        entity.setStatus(AppConstant.ACTIVE.ACTIVE_STATUS);
        entity.setUserIdCreated(jwtTokenUtils.getUserIdFromToken());
        List<String> roleUserLogin;
        if (checkRoleAdmin(AppConstant.role.ROLE_ADMIN)) {
            roleUserLogin = new ArrayList<>();
        } else {
            roleUserLogin = joinRoleUserLogin();
        }
        entity.setFocusRole(StringUtils.join(roleUserLogin, ","));
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity = userRepository.save(entity);
        return Converter.toModel(entity, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return Converter.toList(users, UserDTO.class);
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(Objects.isNull(userEntity)){
            throw new CustomException("user not found", CommonUtils.putError("userId", "ERR_0034"));
        }
        return Converter.toModel(userEntity, UserDTO.class);
    }

    private void validateSaveUser(UserDTO user, String action) {
        if (!action.equals(ACTION)) {
            if (user.getRoleIds().isEmpty()) {
                throw new CustomException("not empty role", CommonUtils.putError("list role id", ""));
            }
        }
        if (user.getUsername() == null || user.getUsername().equals("")) {
            throw new CustomException("not empty username", CommonUtils.putError("username", ""));
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new CustomException("not empty password", CommonUtils.putError("password", ""));
        }
        if (user.getNumberPhone() == null || user.getNumberPhone().equals("")) {
            throw new CustomException("not empty number phone", CommonUtils.putError("number phone", ""));
        }
    }

    private boolean checkRoleAdmin(String authority) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityUtils.getPrincipal().getAuthorities();

        for (GrantedAuthority grantedAuthority : authorities) {
            if (authority.equals(grantedAuthority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    private List<String> joinRoleUserLogin() {
        return SecurityUtils.getPrincipal().getAuthorities().stream().map(Object::toString).collect(Collectors.toList());
    }
}
