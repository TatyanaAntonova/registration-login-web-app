package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.service.RoleService;
import com.example.registrationloginwebapp.service.RoleServiceImpl;
import com.example.registrationloginwebapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserServiceImpl userServiceImpl;
    private final RoleServiceImpl roleServiceIml;

    public BootStrapData(UserServiceImpl userServiceImpl, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceIml = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting in BootStrap");

        System.out.println("----------------- Download roles into repo");
        roleServiceIml.setDefaultRoles();
        System.out.println("There are " + roleServiceIml.getRoles().size() + " roles in repo.");

        System.out.println("----------------- Create DTO taken from web");
        UserDto userDto = new UserDto("Ivan", "Petrov", "email", "password123", "password123");
        UserDto userDto2 = new UserDto("Ivan", "Petrov", "email1", "password123", "password123");
        UserDto userDto3 = new UserDto("Ivan", "Petrov", "email111", "password123", "password123");

        System.out.println("----------------- Transform DTO into User");
        User user = userServiceImpl.transformDtoIntoUser(userDto);
        User user2 = userServiceImpl.transformDtoIntoUser(userDto2);
        User user3 = userServiceImpl.transformDtoIntoUser(userDto3);

        System.out.println("----------------- Download Users into repo");
        userServiceImpl.save(user);
        user2.setRoles(roleServiceIml.getRoles());
        userServiceImpl.save(user2);
        userServiceImpl.save(user2);

        System.out.println("There is/are " + userServiceImpl.getUsers().size() + " user/users in repo.");

        System.out.println("----------------- Delete User from repository");
        if (userServiceImpl.delete(user)) System.out.println("User was deleted successfully!");
        if (userServiceImpl.delete(user3)) System.out.println("User was deleted successfully!");

        System.out.println("There is/are " + userServiceImpl.getUsers().size() + " user/users in repo.");

        /*
        SELECT * FROM ROLES;
        SELECT * FROM USERS;
        SELECT * FROM USERS_ROLES;
         */
    }
}