package com.jake.actuator.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // up(), down(), outOfService() 등 빌더에서 상태값을 정하고 detail 정보가 존재하는 경우 추가
        Health health =
        Health.up()
                .withDetail("key1", "value1")
                .withDetail("key2", "value2")
                .build();
        ;

        return health;
    }
}
