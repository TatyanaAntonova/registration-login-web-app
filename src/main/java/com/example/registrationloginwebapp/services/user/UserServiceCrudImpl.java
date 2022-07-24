package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.repositories.UserRepository;
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
        if (user == null) throw new NullPointerException("User is null and isn't saved.");

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
