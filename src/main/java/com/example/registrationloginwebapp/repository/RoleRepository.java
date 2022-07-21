package com.example.registrationloginwebapp.repository;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleEnum(RoleEnum roleEnum);
}
