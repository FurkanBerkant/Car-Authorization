package com.example.carauthorization.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_group_authorization")
@Data
public class UserGroupAuthorization {
    @Id
    @Column(name = "authorization_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorization_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
