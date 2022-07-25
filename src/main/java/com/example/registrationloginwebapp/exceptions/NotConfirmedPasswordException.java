package com.example.registrationloginwebapp.exceptions;

public class NotConfirmedPasswordException extends RuntimeException{
    public NotConfirmedPasswordException(String message) {
        super(message);
    }
}
