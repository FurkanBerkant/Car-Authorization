package com.example.carauthorization.model.dtos;

import lombok.Data;

@Data
public class RefreshRequest {

    Long userId;
    String refreshToken;
}