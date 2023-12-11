package com.jake.actuator.config;

import com.jake.actuator.metrics.MyStockManager;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStockMeterBinderConfig {

    @Bean
    public MeterBinder myMeterBinder(MyStockManager myStockManager) {

        return registry -> Gauge.builder("my.stock", myStockManager).register(registry);

//        return new MeterBinder() {
//            @Override
//            public void bindTo(MeterRegistry registry) {
//
////                Gauge.builder("my.stock", myStockManager, MyStockManager::getStockCount).register(registry);
//
//                Gauge.builder("my.stock", myStockManager)
//                        .register(registry);
//            }
//        };
    }

}
