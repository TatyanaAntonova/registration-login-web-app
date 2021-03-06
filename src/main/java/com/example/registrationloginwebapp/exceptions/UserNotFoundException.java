package com.example.registrationloginwebapp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String email){
        super(String.format("User with email %email was not found.", email));
    };
}
