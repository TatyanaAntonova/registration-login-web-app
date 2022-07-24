package com.example.registrationloginwebapp.repositories;

import com.example.registrationloginwebapp.models.Role;
import com.example.registrationloginwebapp.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleEnum(RoleEnum roleEnum);
}
