package com.jake.actuator.tags;

import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

//    private final MyQueueManagerWithTags queueManager;

    @Counted(value = "my.counted", extraTags = {"type", "push"})
    @GetMapping("/push")
    public String push() {
//        queueManager.push();

        return "ok";
    }

    @Counted(value = "my.counted", extraTags = {"type", "pop"})
    @GetMapping("/pop")
    public String pop() {
//        queueManager.pop();

        return "ok";
    }
}
