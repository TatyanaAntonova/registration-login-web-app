package com.example.registrationloginwebapp.service;

//TODO add methods
public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("Invalid password.");
    }
}
