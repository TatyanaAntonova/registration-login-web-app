package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.Role;

public interface RoleService {
    boolean save(Role role);

    boolean update(Role role);

    boolean delete(Role role);
}
