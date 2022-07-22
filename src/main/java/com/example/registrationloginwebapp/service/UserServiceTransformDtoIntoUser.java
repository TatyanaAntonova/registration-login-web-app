package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;

public interface UserServiceTransformDtoIntoUser {
    User transformDtoIntoUser(UserDto userDto);
}
