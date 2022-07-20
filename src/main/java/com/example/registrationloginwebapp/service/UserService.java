package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;

public interface UserService {
    User save(UserDto userDto);

    User update(UserDto userDto);

    boolean delete(User user);
}
