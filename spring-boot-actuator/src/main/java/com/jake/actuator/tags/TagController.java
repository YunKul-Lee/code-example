package com.jake.actuator.tags;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

    private final MyQueueManagerWithTags queueManager;

    @GetMapping("/push")
    public String push() {
        queueManager.push();

        return "ok";
    }

    @GetMapping("/pop")
    public String pop() {
        queueManager.pop();

        return "ok";
    }
}
