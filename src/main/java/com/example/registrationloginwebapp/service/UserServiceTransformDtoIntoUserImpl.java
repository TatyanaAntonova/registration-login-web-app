package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceTransformDtoIntoUserImpl implements UserServiceTransformDtoIntoUser {
    @Override
    public User transformDtoIntoUser(UserDto userDto) {
        if(userDto == null) throw new NullPointerException();

        return new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getConfirmedPassword(),
                new ArrayList<>()
        );
    }
}
