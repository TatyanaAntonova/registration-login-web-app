package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

//TODO валидация аннотацией на уровне DTO
@Service
public class UserServiceCheckUserAlreadyExistsImpl implements UserServiceCheckUserAlreadyExists {

    private final UserRepository userRepository;

    public UserServiceCheckUserAlreadyExistsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByEmail(String email) {
        if (userRepository.existsByEmail(email)) return false;

        return true;
    }
}
