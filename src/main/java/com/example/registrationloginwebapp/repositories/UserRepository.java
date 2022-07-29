package com.example.registrationloginwebapp.repositories;

import com.example.registrationloginwebapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    //TODO findByEmail THE SAME? ПЕРЕСМОТРЕТЬ
    boolean existsByEmail(String email);
}
