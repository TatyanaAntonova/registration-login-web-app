package com.example.registrationloginwebapp.models.dtos;

import com.example.registrationloginwebapp.services.validators.Matches;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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
    @Email
    private String email;

    @NonNull
   // @NotEmpty(message = "Password must not be empty.")
    @Min(message = "Password must be more than 10 symbols.", value = 10)
    private String password;

    @NonNull
    @NotEmpty
    private String confirmedPassword;
}
