package com.jake.sse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOError;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SseEventController {

    @GetMapping("events")
    public SseEmitter eventStream() {
        SseEmitter emitter = new SseEmitter();
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
        sseMvcExecutor.execute(() -> {
            executeSseLogic(emitter);
        });

        return emitter;
    }

    private void executeSseLogic(SseEmitter emitter) {
        try {
            for(int counter = 0; counter < 10; counter++) {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .id(String.valueOf(counter))
                        .data("Event data at " + LocalTime.now());

                emitter.send(event);
                Thread.sleep(1000L);
            }
            emitter.complete();
        } catch (IOException | InterruptedException e) {
            emitter.completeWithError(e);
        }
    }
}
