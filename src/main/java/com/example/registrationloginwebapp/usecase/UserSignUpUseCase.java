package com.example.registrationloginwebapp.usecase;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.service.InvalidPasswordException;

public interface UserSignUpUseCase {
    User signUpUser(UserDto userDto) throws InvalidPasswordException;
}
