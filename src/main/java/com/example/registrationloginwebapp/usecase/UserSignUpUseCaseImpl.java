package com.example.registrationloginwebapp.usecase;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.service.UserServiceImpl;

public class UserSignUpUseCaseImpl implements UserSignUpUseCase {
    private final UserServiceImpl userService;

    public UserSignUpUseCaseImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public User signUpUser(UserDto userDto) {

        return new User();//userService.makeUserFromDto(userDto);
    }
}
