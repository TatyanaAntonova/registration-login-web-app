package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.User;

import java.util.List;

public interface UserServiceSetRole {
    void setRole(User user, Role role);
    void setRoles(User user, List<Role> roles);
}
