package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
