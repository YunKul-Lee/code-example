package com.jake.actuator.config.timer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimerConfig {

    @Bean
    public Timer myTimer(MeterRegistry registry) {
        return Timer.builder("my.timer")
                .register(registry);
    }
}
