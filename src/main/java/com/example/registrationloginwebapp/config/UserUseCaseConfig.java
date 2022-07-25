package com.example.registrationloginwebapp.config;

import com.example.registrationloginwebapp.repositories.UserRepository;
import com.example.registrationloginwebapp.services.role.RoleCrudServiceImpl;
import com.example.registrationloginwebapp.services.user.UserCrudServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {
    @Bean("user")
    UserCrudServiceImpl userCrudService(UserRepository userRepository) {
        return new UserCrudServiceImpl(userRepository);
    }

    @Bean("role")
    RoleCrudServiceImpl roleCrudService() {
        return new RoleCrudServiceImpl();
    }

}
