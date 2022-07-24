package com.example.registrationloginwebapp.services.user;

import com.example.registrationloginwebapp.models.User;

public interface UserServiceCrud {
    User save(User user);

    boolean update(User user);

    boolean delete(User user);
}
