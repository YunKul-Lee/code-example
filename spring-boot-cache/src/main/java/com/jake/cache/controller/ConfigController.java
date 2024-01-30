package com.jake.cache.controller;

import com.jake.cache.service.ConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configs")
@RequiredArgsConstructor
@Slf4j
public class ConfigController {

    private final ConfigService configService;

    @GetMapping
    public ResponseEntity<String> getDescription(@RequestParam("code") String code) {
        long startTimeMillis = System.currentTimeMillis();
        String description = configService.getDescription(code);
        log.info("Time used: {}", (System.currentTimeMillis() - startTimeMillis));

        return ResponseEntity.ok().body(description);
    }
}
