package com.example.registrationloginwebapp.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ToString.Exclude
    private Long id;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "password")
    @NonNull
    private String password;

    @NonNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @NonNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    /*@NonNull
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    @ToString.Exclude
    private List<Role> roles;*/
}
