package com.example.carauthorization.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAuth {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
