package com.example.carauthorization.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserResponse {
    private int userId;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Surname cannot be blank")
    private String surName;
    private int company_id;
    private String companyName;
    private String role_name;
}
