package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.models.User;

public interface UserServiceTransformDtoIntoUser {
    User transformDtoIntoUser(UserDto userDto);
}
