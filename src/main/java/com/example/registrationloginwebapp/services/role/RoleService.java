package com.example.registrationloginwebapp.services.role;

import com.example.registrationloginwebapp.models.Role;

public interface RoleService {
    Role getGuestRole();

    boolean save(Role role);

    boolean update(Role role);

    boolean delete(Role role);
}
