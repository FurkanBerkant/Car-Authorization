package com.example.carauthorization.service.concretes;

import com.example.carauthorization.model.RefreshToken;
import com.example.carauthorization.model.User;
import com.example.carauthorization.repository.RefreshTokenRepo;
import com.example.carauthorization.service.abstracts.RefreshTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenManager implements RefreshTokenService {
    @Value("${refresh.token.expires.in}")
    Long expireSeconds;
    private final RefreshTokenRepo refreshTokenRepository;

    public RefreshTokenManager(RefreshTokenRepo refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public String createRefreshToken(User user) {
        RefreshToken token = refreshTokenRepository.findByUserId(user.getId());
        if (token == null) {
            token = new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenRepository.save(token);
        return token.getToken();
    }

    @Override
    public boolean isRefreshExpired(RefreshToken token) {
        return token.getExpiryDate().before(new Date());
    }

    @Override
    public RefreshToken getByUser(Long userId) {
        return refreshTokenRepository.findByUserId(userId);
    }
}