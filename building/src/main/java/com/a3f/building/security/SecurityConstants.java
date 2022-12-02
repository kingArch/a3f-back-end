package com.a3f.building.security;

public class SecurityConstants {
    public static final long EXP_TIME = 432000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_PREFIX = "Jwt-Token";
    public static final String TOKEN_ERR = "Token cannot be verified";
    public static final String AUTH = "Authorities";
    public static final String FORBIDDEN = "Forbidden";
    public static final String[] ALLOWED_PATHS = {"/user/login", "/user/register","user/resetPassword"};

}
