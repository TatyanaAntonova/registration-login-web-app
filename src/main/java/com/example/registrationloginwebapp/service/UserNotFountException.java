package com.example.registrationloginwebapp.service;

public class UserNotFountException extends RuntimeException{
    public UserNotFountException(String email){
        super(String.format("User with email %email was not found.", email));
    };
}
