package com.example.classroomiot.logic.utils;

import com.example.classroomiot.logic.dto.UserPrincipalOauth2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * SecurityUtils
 *
 */
public class SecurityUtils {

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
