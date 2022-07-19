package com.example.registrationloginwebapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @NonNull
    //TODO
    private String rights;

    //@ManyToMany(mappedBy = "roles")
    //private Set<User> userSet;
}
