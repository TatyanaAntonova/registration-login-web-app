package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.User;
import org.springframework.stereotype.Service;

public interface UserServiceCheckUserAlreadyExists {
    boolean existsByEmail (String email);
}
