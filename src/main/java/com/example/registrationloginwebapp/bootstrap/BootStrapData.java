package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.RoleEnum;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.RoleRepository;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public BootStrapData(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Starting in BootStrap");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleEnum.ADMIN, "rights"));
        roles.add(new Role(RoleEnum.GUEST, "rights"));

        User user = new User("Ivan", "Petrov", "email", "password", "confirmedPassword", RoleEnum.ADMIN);
        //user.setRoles(roles);
        userRepository.save(user);
        System.out.println(userRepository.count());

        roleRepository.save(new Role(RoleEnum.ADMIN, "rights"));
        roleRepository.save(new Role(RoleEnum.ADMIN, "rights"));
        roleRepository.save(new Role(RoleEnum.GUEST, "rights"));
        System.out.println(roleRepository.count());
    }
}