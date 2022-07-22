package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceCheckUniqueEmail {
    boolean checkUniqueEmail (User user);
}
