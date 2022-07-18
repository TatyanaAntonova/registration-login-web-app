package com.example.registrationloginwebapp.repository;

import com.example.registrationloginwebapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
}
