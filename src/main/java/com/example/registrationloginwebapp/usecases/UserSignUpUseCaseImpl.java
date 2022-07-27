package com.example.registrationloginwebapp.usecases;

import com.example.registrationloginwebapp.models.UserDto;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.services.user.UserCrudServiceImpl;
import com.example.registrationloginwebapp.services.user.UserServiceTransformDtoIntoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpUseCaseImpl implements UserSignUpUseCase {
    private static final Logger log = LoggerFactory.getLogger(UserSignUpUseCaseImpl.class);
    private final UserCrudServiceImpl userCrudService;
    private final UserServiceTransformDtoIntoUser transformDtoIntoUser;

    public UserSignUpUseCaseImpl(UserCrudServiceImpl userCrudService,
                                 UserServiceTransformDtoIntoUser transformDtoIntoUser) {
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
            user = transformDtoIntoUser.transformDtoIntoUser(userDto);
            userCrudService.save(user);
            log.info("User with email \"" + user.getEmail() + "\" signed up successfully.");
        } else {
            log.info("User with email \"" + user.getEmail() + "\" already exists!");
        }

        //TODO return null is bad practice
        return user;
    }
}
