package com.example.registrationloginwebapp.services.role;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.RoleEnum;
import com.example.registrationloginwebapp.repositories.RoleRepository;
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

    public Role getGuestRole() {
        return roleRepository.findByRoleEnum(RoleEnum.GUEST);
    }

    //TODO save, update, delete
    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }
}
