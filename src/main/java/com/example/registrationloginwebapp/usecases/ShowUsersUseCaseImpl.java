package com.example.registrationloginwebapp.usecases;

import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.repositories.UserRepository;

import java.util.List;

public class ShowUsersUseCaseImpl implements ShowUsersUseCase {
    private final UserRepository userRepository;

    public ShowUsersUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }
}
