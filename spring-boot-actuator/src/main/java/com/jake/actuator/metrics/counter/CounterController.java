package com.jake.actuator.metrics.counter;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class CounterController {

//    private final MyHttpRequestManager myHttpRequestManager;

    private final MeterRegistry meterRegistry;

    @Counted("my.counted.counter")
    @GetMapping("/req")
    public String req() {

//        Counter.builder("my.http.request")
//                .register(meterRegistry)
//                .increment();

//        myHttpRequestManager.increase();

        return "ok";
    }
}
