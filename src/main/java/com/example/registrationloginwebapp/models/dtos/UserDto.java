package com.example.registrationloginwebapp.models.dtos;

import com.example.registrationloginwebapp.validators.Matches;
import lombok.*;

import javax.validation.constraints.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Matches(field = "password", verifyField = "confirmedPassword")
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
    @Size(min = 10, message = "Password must be more than 10 symbols.")
    private String password;

    @NonNull
    @NotEmpty
    private String confirmedPassword;
}
