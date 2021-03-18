package com.genetics.nuka_api.security;

public class SecurityConstant {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final int EXPIRATION_TIME = 120_000;
}