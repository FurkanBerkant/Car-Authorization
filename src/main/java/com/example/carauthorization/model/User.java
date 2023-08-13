package com.example.carauthorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name", unique = true)
    @NotBlank(message = "Name cannot be blank")
    private String userName;
    @Column(name = "surname", unique = true)
    @NotBlank(message = "Surname cannot be blank")
    private String surName;

    @Column(name = "password",length = 100)
    @NotBlank(message = "Password cannot be blank")
    private String password;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
