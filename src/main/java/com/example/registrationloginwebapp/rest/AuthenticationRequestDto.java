package com.example.registrationloginwebapp.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String email;
    private String password;
}
