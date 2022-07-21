package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.User;

public interface UserService {
    boolean save(User user);

    boolean update(User user);

    boolean delete(User user);
}
