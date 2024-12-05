package com.sds.codepusher.login.jwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RedisTemplate<String, String> redisTemplate;

    public void storeRefreshToken(String userId, String refreshToken, long expirationTime) {
        redisTemplate.opsForValue().set(userId, refreshToken, expirationTime, TimeUnit.MILLISECONDS);
    }

    public boolean validateRefreshToken(String userId, String refreshToken) {
        String storedToken = redisTemplate.opsForValue().get(userId);
        return refreshToken.equals(storedToken);
    }

    public void deleteRefreshToken(String userId) {
        redisTemplate.delete(userId);
    }
}
