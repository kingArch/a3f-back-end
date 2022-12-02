package com.a3f.building.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.a3f.building.dtos.UserDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class LoginService {

    @Resource(name = "authManager")
    AuthenticationManager authenticationManager;

    public String authenticate(final UserDto user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(),
                user.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return getToken(auth, request);
    }

    private String getToken(Authentication authResult, HttpServletRequest request) {
        User user = (User) authResult.getPrincipal();
        List<String> claims = new ArrayList<>();
        claims.add("USERX");
        // in real-world app, the secret should be provided from a server
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        final String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",
                        user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign((algorithm));
        return accessToken;
    }
}
