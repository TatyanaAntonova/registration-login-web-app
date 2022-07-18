package com.example.registrationloginwebapp.model;

import javax.persistence.*;

@Convert(converter = RoleConverter.class, attributeName = "value")
public enum Role {
    @Enumerated(EnumType.STRING)
    ADMIN,
    @Enumerated(EnumType.STRING)
    GUEST
}
