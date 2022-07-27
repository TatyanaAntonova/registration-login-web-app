package com.example.registrationloginwebapp.models;

import com.example.registrationloginwebapp.validators.FieldsValueMatch;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NonNull
    @NotEmpty(message = "First name must not be empty.")
    private String firstName;

    @NonNull
    @NotEmpty(message = "Last name must not be empty.")
    private String lastName;

    @NonNull
    @NotEmpty(message = "Email must not be empty.")
    @Email(message = "Email should be valid")
    private String email;

    @NonNull
    @NotEmpty(message = "Password must not be empty.")
    @Size(min = 10, max = 50, message = "Password must be more than 10 symbols.")
    private String password;

    //TODO validate confirmed password field
    @NonNull
    @NotEmpty(message = "Confirmed Password must not be empty.")
    //@FieldsValueMatch(field = "password", fieldMatch = "confirmedPassword", message = "Passwords do not match!")
    private String confirmedPassword;
}
