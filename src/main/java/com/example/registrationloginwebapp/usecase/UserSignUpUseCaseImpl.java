package com.example.registrationloginwebapp.usecase;

import com.example.registrationloginwebapp.dto.UserDto;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.service.*;

public class UserSignUpUseCaseImpl implements UserSignUpUseCase {
    private final UserServiceTransformDtoIntoUserImpl userServiceTransformDtoIntoUser;
    private final UserServiceCheckUniqueEmail userServiceCheckUniqueEmail;
    private final UserServiceCrudImpl userServiceCrud;
    private final RoleServiceImpl roleService;

    public UserSignUpUseCaseImpl(UserServiceCheckUniqueEmail userServiceCheckUniqueEmail, UserServiceTransformDtoIntoUserImpl userServiceTransformDtoIntoUser, UserServiceCrudImpl userServiceCrud, User user, UserDto userDto, RoleServiceImpl roleService) {
        this.userServiceCheckUniqueEmail = userServiceCheckUniqueEmail;
        this.userServiceTransformDtoIntoUser = userServiceTransformDtoIntoUser;
        this.userServiceCrud = userServiceCrud;
        this.roleService = roleService;
    }

    @Override
    public User signUpUser(UserDto userDto) throws InvalidPasswordException {
        //TODO add not confirmed password exception
        if(userDto.getPassword() != userDto.getConfirmedPassword()) throw new InvalidPasswordException();

        //TODO make setter or constructor with User parameter
        User user = userServiceTransformDtoIntoUser.transformDtoIntoUser(userDto);

        if (userServiceCheckUniqueEmail.checkUniqueEmail(user)) {
            return userServiceCrud.save(user);
        }

        //TODO return null is bad practice
        return null;
    }
}
