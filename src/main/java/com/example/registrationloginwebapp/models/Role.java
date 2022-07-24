package com.example.registrationloginwebapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "role_enum"))
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"roleEnum"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_enum")
    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @NonNull
    //TODO
    private String rights;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
