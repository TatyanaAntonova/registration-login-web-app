package com.example.registrationloginwebapp.services.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email){
        super("A user with such an email already exists: \"" + email + "\".");
    }
}
