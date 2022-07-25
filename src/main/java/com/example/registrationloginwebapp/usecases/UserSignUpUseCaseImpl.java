package com.example.registrationloginwebapp.usecases;

import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.services.user.UserCrudServiceImpl;
import com.example.registrationloginwebapp.services.user.UserServiceTransformDtoIntoUser;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpUseCaseImpl implements UserSignUpUseCase {
    // TODO ЕСЛИ ИСПОЛЬЗОВАТЬ ИНТЕРФЕЙС CrudService + @QUALIFIED("user"), бин класса находит,
    // но метод по поиску имейла не видит
    private final UserCrudServiceImpl userCrudService;
    private final UserServiceTransformDtoIntoUser transformDtoIntoUser;

    public UserSignUpUseCaseImpl(UserCrudServiceImpl userCrudService, UserServiceTransformDtoIntoUser transformDtoIntoUser) {
        this.userCrudService = userCrudService;
        this.transformDtoIntoUser = transformDtoIntoUser;
    }

    /**
     * @param userDto
     * @return User
     * Before sigh up User UserDto have to be checked.
     * 1. User already exist. Check by email.
     */
    @Override
    public User signUpUser(UserDto userDto) {
        if (userDto == null) {
            throw new NullPointerException("UserDto is null");
        }

        User user = null;
        String checkEmail = userDto.getEmail();

        if (!userCrudService.findByEmail(checkEmail)) {
            System.out.println("Not found such email: " + checkEmail);

            user = transformDtoIntoUser.transformDtoIntoUser(userDto);
            userCrudService.save(user);
            System.out.println(user + " was signed up successfully!");
        }

        //TODO return null is bad practice
        return user;
    }
}
