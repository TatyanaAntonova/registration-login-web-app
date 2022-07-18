package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;

    public BootStrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting in BootStrap");
        User user = new User("Ivan", "Petrov", "email", "password", "confirmedPassword", new HashSet<Role>());
        userRepository.save(user);
        System.out.println(userRepository.count());
    }
}
