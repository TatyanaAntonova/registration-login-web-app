package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.User;
import com.example.registrationloginwebapp.repositories.RoleRepository;
import com.example.registrationloginwebapp.services.role.RoleServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceSetRoleImpl implements UserServiceSetRole {
    private final RoleRepository roleRepository;
    private final RoleServiceImpl roleService;

    public UserServiceSetRoleImpl(RoleRepository roleRepository, RoleServiceImpl roleService) {
        this.roleRepository = roleRepository;
        this.roleService = roleService;
    }

    @Override
    public void setRole(User user, Role role) {
        //TODO
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getGuestRole());
        user.setRoles(roles);
    }

    @Override
    public void setRoles(User user, List<Role> roles) {
        user.setRoles(roles);
    }
}
