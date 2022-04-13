package com.example.classroomiot.logic.service.impl;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.dto.UserPrincipalOauth2;
import com.example.classroomiot.logic.entity.UserEntity;
import com.example.classroomiot.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userCustomService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, AppConstant.ACTIVE.ACTIVE_STATUS);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserPrincipalOauth2.createPrincipalOauth2(userEntity);
    }
}