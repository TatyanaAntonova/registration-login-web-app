package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.Status;
import com.example.registrationloginwebapp.models.UserDto;
import com.example.registrationloginwebapp.models.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceTransformDtoIntoUserImpl implements UserServiceTransformDtoIntoUser {
    @Override
    public User transformDtoIntoUser(UserDto userDto) {
        if (userDto == null) throw new NullPointerException("UserDto is null.");

        boolean confirmedPassword = userDto.getPassword().equals(userDto.getConfirmedPassword());

        if (confirmedPassword) {
            return new User(
                    userDto.getEmail(),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    userDto.getPassword(),
                    Role.USER,
                    Status.ACTIVE
            );
        }

        return null;
    }
}
