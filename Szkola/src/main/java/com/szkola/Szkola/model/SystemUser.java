package com.szkola.Szkola.model;

import lombok.Data;
import javax.persistence.*;

import java.util.Set;

@Entity
@Data
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    private Set<Role> roles;
}