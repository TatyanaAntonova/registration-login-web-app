package com.example.registrationloginwebapp.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role role) {
        switch (role) {
            case ADMIN:
                return "admin";
            case GUEST:
                return "guest";
            default:
                throw new IllegalArgumentException("No such Enum in Role class: " + role.name());
        }
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "admin":
                return Role.ADMIN;
            case "guest":
                return Role.GUEST;
            default:
                throw new IllegalArgumentException("Unexpected value of dbData: " + dbData);
        }
    }


}
