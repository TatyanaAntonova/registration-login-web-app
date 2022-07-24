package com.example.registrationloginwebapp.services.exceptions;

public class NotConfirmedPasswordException extends RuntimeException{
    public NotConfirmedPasswordException(String message) {
        super(message);
    }
}
