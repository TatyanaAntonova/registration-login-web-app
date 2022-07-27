package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.exceptions.NotFoundException;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.repositories.UserRepository;
import com.example.registrationloginwebapp.services.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("user")
public class UserCrudServiceImpl implements CrudService<User, Long> {
    private final UserRepository userRepository;

    public UserCrudServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    //TODO NEW METHOD
    public boolean findByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public void delete(User object) {
        if (!userRepository.existsById(object.getId())) {
            throw new NotFoundException("User not found");
        }

        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
