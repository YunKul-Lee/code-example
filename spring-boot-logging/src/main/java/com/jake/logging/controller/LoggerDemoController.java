package com.jake.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoggerDemoController {

//    private static final LoggerFactory log = LoggerFactory.getLogger();

    @GetMapping(value = "/log", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Object> loggerTest(@RequestParam("q") String q) {
        Map<String, String> response = new HashMap<>();

        try {
            log.info("started...");
            response.put("message", "normal flow of the application");

            if(q.equalsIgnoreCase("exception")) {
                throw new RuntimeException("Testing the exception logging mechanism");
            }
            log.info("before sending response");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());

            return ResponseEntity.internalServerError().build();
        }

    }
}
