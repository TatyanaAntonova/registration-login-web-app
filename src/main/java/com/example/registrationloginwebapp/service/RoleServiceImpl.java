package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.RoleEnum;
import com.example.registrationloginwebapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getGuestRole(){
        return null;
    }

    //TODO save, update, delete
    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean save(Role role) {
        return false;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }
}
