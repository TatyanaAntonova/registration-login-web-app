package com.example.registrationloginwebapp.validators;

import com.example.registrationloginwebapp.models.dtos.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchesValidator implements ConstraintValidator<Matches, Object> {
    private String field;
    private String verifyField;
    private final UserDto userDto;

    public MatchesValidator(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public void initialize(Matches constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.verifyField = constraintAnnotation.verifyField();
    }


    //TODO validator
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldObj = userDto.getPassword();
        Object verifyFieldObj = userDto.getConfirmedPassword();

        boolean neitherSet = (fieldObj == null) && (verifyFieldObj == null);

        if (neitherSet) {
            return true;
        }

        boolean matches = (fieldObj != null) && fieldObj.equals(verifyFieldObj);

        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("message")
                    .addNode(verifyField)
                    .addConstraintViolation();
        }

        return matches;
    }
}

