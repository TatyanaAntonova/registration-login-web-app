package com.example.registrationloginwebapp.dto;

import com.example.registrationloginwebapp.model.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoleDto {
    @NonNull
    private RoleEnum roleEnum;
    @NonNull
    private String rights;
}
