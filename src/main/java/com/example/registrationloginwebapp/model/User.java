package com.example.registrationloginwebapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"firstName", "lastName", "email"})
@EqualsAndHashCode(of = {"id"})

public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String confirmedPassword;

    @NonNull
    private Set<Role> roles;
}
