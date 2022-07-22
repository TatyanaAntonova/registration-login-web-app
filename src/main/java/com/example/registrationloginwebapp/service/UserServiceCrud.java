package com.example.registrationloginwebapp.service;

import com.example.registrationloginwebapp.model.User;

public interface UserServiceCrud {
    User save(User user);

    boolean update(User user);

    boolean delete(User user);
}
