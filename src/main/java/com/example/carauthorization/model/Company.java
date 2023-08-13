package com.example.carauthorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "companies")
@Data
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;
    @Column(name = "company_name", unique = true)
    @NotBlank(message = "Company name cannot be blank")
    private String companyName;

}
