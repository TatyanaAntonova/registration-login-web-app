package com.example.registrationloginwebapp.usecases;

import com.example.registrationloginwebapp.models.dtos.UserDto;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.services.exceptions.InvalidPasswordException;
import com.example.registrationloginwebapp.services.exceptions.NotConfirmedPasswordException;
import com.example.registrationloginwebapp.services.exceptions.UserAlreadyExistsException;
import com.example.registrationloginwebapp.services.role.RoleService;
import com.example.registrationloginwebapp.services.user.*;

import java.net.UnknownServiceException;

public class UserSignUpUseCaseImpl implements UserSignUpUseCase {
    private final UserServiceTransformDtoIntoUser transformDtoIntoUser;
    private final UserServiceCheckUserAlreadyExists checkUserAlreadyExists;
    private final UserServiceCrud userServiceCrud;
    private final RoleService roleService;
    private final UserServiceSetRole userServiceSetRole;

    public UserSignUpUseCaseImpl(
            UserServiceTransformDtoIntoUser transformDtoIntoUser,
            UserServiceCheckUserAlreadyExists checkUserAlreadyExists,
            UserServiceCrud userServiceCrud,
            RoleService roleService,
            UserServiceSetRole userServiceSetRole) {
        this.transformDtoIntoUser = transformDtoIntoUser;
        this.checkUserAlreadyExists = checkUserAlreadyExists;
        this.userServiceCrud = userServiceCrud;
        this.roleService = roleService;
        this.userServiceSetRole = userServiceSetRole;
    }

    /**
     * @param userDto
     * @return User
     * Before sigh up user UserDto have to be checked.
     * 1. Password != ConfirmedPassword
     * 2. Validate password.
     * 3. User already exist. Check by email.
     */
    @Override
    public User signUpUser(UserDto userDto) {
        User user = null;

        try {
            if (userDto == null) throw new NullPointerException("UserDto is null.");
            //TODO validators
            if (!userDto.getPassword().equals(userDto.getConfirmedPassword())) throw new NotConfirmedPasswordException("Password isn't confirmed.");

            if (userDto.getPassword().length() < 10) throw new InvalidPasswordException("Password isn't valid.");

            String checkEmail = userDto.getEmail();
            if (!checkUserAlreadyExists.existsByEmail(checkEmail)) throw new UserAlreadyExistsException(checkEmail);

            // TODO нужна ли проверка на null и обработки исключений во всей цепочке или только в текущем методе
            // решение: пробрасывать в сервисах, обрабатывать в use case

            user = userServiceCrud.save(transformDtoIntoUser.transformDtoIntoUser(userDto));
            userServiceSetRole.setRole(user, roleService.getGuestRole());
            System.out.println("User was finished successfully.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //TODO return null is bad practice
        return user;
    }
}
