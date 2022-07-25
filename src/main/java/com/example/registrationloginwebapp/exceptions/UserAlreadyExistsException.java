package com.example.registrationloginwebapp.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email){
        super("A user with such an email already exists: \"" + email + "\".");
    }
}
