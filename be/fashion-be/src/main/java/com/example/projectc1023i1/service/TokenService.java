package com.example.projectc1023i1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String getToken(String username) {
        String tokenKey = "TOKEN_" + username;  // Tạo khóa cho token của người dùng
        return redisTemplate.opsForValue().get(tokenKey);  // Lấy giá trị token từ Redis
    }
}
