package com.jake.actuator.config.metrics;

import com.jake.actuator.metrics.counter.MyHttpRequestManagerWithoutMicrometer;
import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CounterConfigWithMeterBinder {

    @Bean
    public MeterBinder myCounterWithMeterBinder(MyHttpRequestManagerWithoutMicrometer myManager) {
        return registry -> FunctionCounter.builder("my.function.counter", myManager, MyHttpRequestManagerWithoutMicrometer::getCount).register(registry);
    }
}
