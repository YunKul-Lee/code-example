package com.jake.rediscluster.controller;

import com.jake.rediscluster.model.User;
import com.jake.rediscluster.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/cache")
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @PostMapping
    public User cacheUser(@RequestBody User user) {
        cacheService.cacheUser(user);
        return user;
    }

    @GetMapping("/{name}")
    public User getCachedUserByName(@PathVariable String name) {
        return cacheService.getCachedUserByName(name);
    }
}
