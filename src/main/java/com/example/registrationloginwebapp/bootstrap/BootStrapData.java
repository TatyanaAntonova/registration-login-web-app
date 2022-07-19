package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.RoleEnum;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.RoleRepository;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        roles.add(new Role(RoleEnum.ADMIN, "admin rights"));
        roles.add(new Role(RoleEnum.GUEST, "guest rights"));
        System.out.println(roles.size());

        User user = new User("Ivan", "Petrov", "email", "password", "confirmedPassword", roles);
        User user2 = new User("Ivan", "Petrov", "email2", "password", "confirmedPassword", roles);
        User user3 = new User("Ivan", "Petrov", "email3", "password", "confirmedPassword", roles);

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);

        userRepository.saveAll(userList);

        System.out.println(userRepository.count());

        System.out.println(roleRepository.count());
        /*
        SELECT * FROM ROLES;
        SELECT * FROM USERS;
        SELECT * FROM USERS_ROLES;
         */
    }
}