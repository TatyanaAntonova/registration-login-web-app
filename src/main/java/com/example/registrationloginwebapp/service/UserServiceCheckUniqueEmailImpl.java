package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceCheckUniqueEmailImpl implements UserServiceCheckUniqueEmail {
    private final UserRepository userRepository;

    public UserServiceCheckUniqueEmailImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkUniqueEmail(User user) {
        if(user == null) throw new NullPointerException();

        if (userRepository.existsByEmail(user.getEmail())) return false;

        return true;
    }
}
