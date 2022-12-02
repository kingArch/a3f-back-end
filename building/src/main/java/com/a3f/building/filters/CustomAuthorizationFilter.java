package com.a3f.building.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("-s--");

        if (request.getServletPath().equals("/login")) {
            filterChain.doFilter(request, response);
        } else {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                try {
                    String token = authHeader.substring("Bearer ".length());
                    Algorithm algo = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algo).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String username = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    if (null != roles) {
                        for (String role : roles) {
                            authorities.add(new SimpleGrantedAuthority(role));
                        }
                    }
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,
                            null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    response.setStatus(200);
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    log.info(e.getMessage());
                    response.setHeader("error", e.getMessage());
                    response.setStatus(403);
                    Map<String, String> error = new HashMap<>();
                    error.put("error", e.getMessage());
                }

            } else {
                filterChain.doFilter(request, response);
            }
        }

    }

}
