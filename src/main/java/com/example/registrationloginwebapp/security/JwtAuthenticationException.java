package com.example.registrationloginwebapp.security;

import io.jsonwebtoken.JwtException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class JwtAuthenticationException extends JwtException {
    private HttpStatus httpStatus;

    public JwtAuthenticationException(String message) {
        super(message);
    }

    public JwtAuthenticationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
