package com.a3f.building.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a3f.building.dtos.AuthRespDto;
import com.a3f.building.dtos.UserDto;
import com.a3f.building.entities.UserEntity;
import com.a3f.building.services.implementations.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@CrossOrigin
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<AuthRespDto> login(final HttpServletRequest request, final HttpServletResponse response,
            @RequestBody UserDto body) {
        final String authToken = "Bearer " + loginService.authenticate(body, request);
        response.setHeader("auth", authToken);
        return ResponseEntity.ok(new AuthRespDto(authToken));
    }
}
