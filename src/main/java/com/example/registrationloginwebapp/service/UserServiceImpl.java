package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getConfirmedPassword(),
                new HashSet<>()
        );

        userRepository.save(user);
        return user;
    }

    @Override
    public User update(UserDto userDto) {

        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }
}
