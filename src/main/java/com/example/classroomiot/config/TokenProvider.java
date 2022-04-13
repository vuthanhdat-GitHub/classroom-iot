package com.example.classroomiot.config;

import com.example.classroomiot.constants.AppConstant;
import com.example.classroomiot.logic.utils.SecurityUtils;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenProvider {

    @Autowired
    private TokenStore tokenStore;

    public String getUsernameFromToken(){
        return getTokenInfo(AppConstant.O2Constants.USER_NAME).toString();
    }

    UsernamePasswordAuthenticationToken getAuthentication(Collection<? extends GrantedAuthority> authorities , final UserDetails userDetails){
        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public Object getTokenInfo(String key){
        Optional<String> tokenValue = SecurityUtils.getTokenValue();
        if (tokenValue.isEmpty()) {
            return null;
        }
        final OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue.get());
        Map<String, Object> additionalInformation = accessToken.getAdditionalInformation();
        return additionalInformation.get(key);
    }
}