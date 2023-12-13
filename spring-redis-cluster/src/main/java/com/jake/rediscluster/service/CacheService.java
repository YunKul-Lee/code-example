package com.jake.rediscluster.service;

import com.jake.rediscluster.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void cacheUser(User user) {
        redisTemplate.opsForValue().set(user.getName(), user.getCity(), Duration.ofMinutes(2L));
    }

    public User getCachedUserByName(String name) {
        return (User)redisTemplate.opsForValue().get(name);
    }
}
