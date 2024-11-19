package com.itembox.itembox.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.itembox.itembox.business.services.IAuthService;
import com.itembox.itembox.persistance.dto.AuthLoginDto;
import com.itembox.itembox.web.config.jwt.CustomTokenProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomTokenProvider tokenProvider;

    @Override
    public String login(AuthLoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String authenticationToken = tokenProvider.generateToken(authentication);
        return authenticationToken;
    }
}
