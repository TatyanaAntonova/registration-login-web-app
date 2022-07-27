package com.example.registrationloginwebapp.usecases;

import com.example.registrationloginwebapp.models.UserDto;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.exceptions.InvalidPasswordException;

public interface UserSignUpUseCase {
    User signUpUser(UserDto userDto) throws InvalidPasswordException;
}
