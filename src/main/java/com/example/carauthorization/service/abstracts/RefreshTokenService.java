package com.example.carauthorization.service.abstracts;

import com.example.carauthorization.model.RefreshToken;
import com.example.carauthorization.model.User;

public interface RefreshTokenService {
    String createRefreshToken(User user);
    boolean isRefreshExpired(RefreshToken token);
    RefreshToken getByUser(Long userId);
}
