package com.example.registrationloginwebapp.config;

import com.example.registrationloginwebapp.services.role.RoleService;
import com.example.registrationloginwebapp.services.user.UserServiceCheckUserAlreadyExists;
import com.example.registrationloginwebapp.services.user.UserServiceCrud;
import com.example.registrationloginwebapp.services.user.UserServiceSetRole;
import com.example.registrationloginwebapp.services.user.UserServiceTransformDtoIntoUser;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCase;
import com.example.registrationloginwebapp.usecases.UserSignUpUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {
    private final UserServiceTransformDtoIntoUser transformDtoIntoUser;
    private final UserServiceCheckUserAlreadyExists checkUserAlreadyExists;
    private final UserServiceCrud userServiceCrud;
    private final RoleService roleService;
    private final UserServiceSetRole userServiceSetRole;

    public UserUseCaseConfig(UserServiceTransformDtoIntoUser transformDtoIntoUser,
                             UserServiceCheckUserAlreadyExists checkUserAlreadyExists,
                             UserServiceCrud userServiceCrud,
                             RoleService roleService, UserServiceSetRole userServiceSetRole) {
        this.transformDtoIntoUser = transformDtoIntoUser;
        this.checkUserAlreadyExists = checkUserAlreadyExists;
        this.userServiceCrud = userServiceCrud;
        this.roleService = roleService;
        this.userServiceSetRole = userServiceSetRole;
    }

    @Bean
    public UserSignUpUseCase userSignUpUseCase(){
        return new UserSignUpUseCaseImpl(
                transformDtoIntoUser,
                checkUserAlreadyExists,
                userServiceCrud,
                roleService,
                userServiceSetRole);
    }


}
