package com.example.registrationloginwebapp.bootstrap;

import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.services.role.RoleService;
import com.example.registrationloginwebapp.services.user.UserServiceCrud;
import com.example.registrationloginwebapp.services.user.UserServiceTransformDtoIntoUser;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserServiceCrud userService;
    private final RoleService roleService;
    private final UserServiceTransformDtoIntoUser transformDtoIntoUser;
    private final UserSignUpUseCase userSignUpUseCase;
    private final UserServiceCrud userServiceCrud;

    public BootStrapData(UserServiceCrud userService, RoleService roleService, UserServiceTransformDtoIntoUser transformDtoIntoUser, UserSignUpUseCase userSignUpUseCase, UserServiceCrud userServiceCrud) {
        this.userService = userService;
        this.roleService = roleService;
        this.transformDtoIntoUser = transformDtoIntoUser;
        this.userSignUpUseCase = userSignUpUseCase;
        this.userServiceCrud = userServiceCrud;
    }

    @Override
    public void run(String... args) throws Exception {
      /*  System.out.println("Starting in BootStrap");

        System.out.println("----------------- Create DTO taken from web");
        UserDto userDto = new UserDto("Ivan", "Petrov", "email", "password123", "password123");

        System.out.println("----------------- Transform DTO into User");
        User user = transformDtoIntoUser.transformDtoIntoUser(userDto);

        System.out.println("----------------- Download Users into repo");
        System.out.println(userSignUpUseCase.signUpUser(userDto));
        System.out.println(userSignUpUseCase.signUpUser(userDto));
        System.out.println(userSignUpUseCase.signUpUser(null));
*/
/*
        System.out.println("There is/are " + userServiceImpl.getUsers().size() + " user/users in repo.");

        System.out.println("----------------- Delete User from repository");
        if (userServiceImpl.delete(user)) System.out.println("User was deleted successfully!");
        if (userServiceImpl.delete(user3)) System.out.println("User was deleted successfully!");

        System.out.println("There is/are " + userServiceImpl.getUsers().size() + " user/users in repo.");
*/
        /*
        SELECT * FROM ROLES;
        SELECT * FROM USERS;
        SELECT * FROM USERS_ROLES;
         */
    }
}