package com.example.registrationloginwebapp.usecase;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;

public interface UserSignUpUseCase {
    User signUpUser(UserDto userDto);
}
