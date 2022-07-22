package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;

import java.util.List;

public interface UserServiceSetRole {
    void setRole(User user, Role role);
    void setRoles(User user, List<Role> roles);
}
