package com.example.registrationloginwebapp.model;

import javax.persistence.*;

//@Convert(converter = RoleConverter.class, attributeName = "value")
public enum RoleEnum {
    //@Enumerated(EnumType.STRING)
    ADMIN,
    //@Enumerated(EnumType.STRING)
    GUEST;
}
