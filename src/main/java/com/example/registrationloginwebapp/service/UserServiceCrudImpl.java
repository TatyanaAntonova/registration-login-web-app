package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.RoleRepository;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceCrudImpl implements UserServiceCrud {
    private final UserRepository userRepository;

    public UserServiceCrudImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user == null) throw new NullPointerException();

        return userRepository.save(user);
    }

    @Override
    public boolean update(User user) {
        if (user == null) throw new NullPointerException();

        return false;
    }

    @Override
    public boolean delete(User user) {
        if (user == null) throw new NullPointerException();

        if (userRepository.existsByEmail(user.getEmail())) {
            userRepository.delete(user);
            return true;
        }

        return false;
    }



    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
