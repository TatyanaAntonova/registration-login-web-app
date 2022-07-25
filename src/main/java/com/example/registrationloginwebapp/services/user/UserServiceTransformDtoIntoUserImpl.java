package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceTransformDtoIntoUserImpl implements UserServiceTransformDtoIntoUser {
    @Override
    public User transformDtoIntoUser(UserDto userDto) {
        if (userDto == null) throw new NullPointerException("UserDto is null.");

        boolean confirmedPassword = userDto.getPassword().equals(userDto.getConfirmedPassword());

        if (confirmedPassword) {
            return new User(
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    userDto.getEmail(),
                    userDto.getPassword(),
                    new ArrayList<Role>()
            );
        }

        return null;
    }
}
