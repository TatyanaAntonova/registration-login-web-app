package com.example.registrationloginwebapp.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<RoleEnum, String> {
    @Override
    public String convertToDatabaseColumn(RoleEnum role) {
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
    public RoleEnum convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "admin":
                return RoleEnum.ADMIN;
            case "guest":
                return RoleEnum.GUEST;
            default:
                throw new IllegalArgumentException("Unexpected value of dbData: " + dbData);
        }
    }
}