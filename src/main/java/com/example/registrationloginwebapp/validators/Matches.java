package com.example.registrationloginwebapp.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = MatchesValidator.class)
@Documented
public @interface Matches {

    String field();

    String verifyField();

    String message() default "Passwords don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
