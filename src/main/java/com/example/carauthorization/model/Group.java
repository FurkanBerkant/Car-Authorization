package com.example.carauthorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;
    @Column(name = "group_name", unique = true)
    @NotBlank(message = "Group name cannot be blank")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Group parentGroup;

}
