package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.RoleEnum;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.RoleRepository;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean save(User user) {
        //TODO check email in usecase
        if (userRepository.existsByEmail(user.getEmail())) return false;

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            userRepository.delete(user);
            return true;
        }

        return false;
    }

    public void setRoles(User user, List<Role> roles) {
        user.setRoles(roles);
    }

    public User transformDtoIntoUser(UserDto userDto) {
        return new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getConfirmedPassword()
        );
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
