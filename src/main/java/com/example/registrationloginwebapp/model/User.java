package com.example.registrationloginwebapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"firstName", "lastName", "email"})
@EqualsAndHashCode(of = {"id"})

public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Transient
    private String confirmedPassword;

    @NonNull
    //@ManyToMany(fetch = FetchType.EAGER)
    //private Set<Role> roles;
    private Role role;
}
