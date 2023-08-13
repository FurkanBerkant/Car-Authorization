package com.example.carauthorization.repository;

import com.example.carauthorization.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByUserId(Long userId);
}
