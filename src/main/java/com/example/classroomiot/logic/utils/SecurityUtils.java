package com.example.classroomiot.logic.utils;

import com.example.classroomiot.logic.dto.UserPrincipalOauth2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * SecurityUtils
 *
 * @author DatDV
 */
@Configuration
public class SecurityUtils {
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    public static UserPrincipalOauth2 getPrincipal(){
        UserPrincipalOauth2 userPrincipalOauth2 = (UserPrincipalOauth2) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipalOauth2;
    }

    @SuppressWarnings("unchecked")
    public static List<String> getAuthorities(){
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }

    public static boolean isAdmin() {
        return getAuthorities().contains("ROLE_ADMIN");
    }

    public static boolean isUser() {
        return getAuthorities().contains("ROLE_USER");
    }
}
