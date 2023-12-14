package com.jake.actuator.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        Health.Builder builder = getStatus() ? Health.up() : Health.down();

        // up(), down(), outOfService() 등 빌더에서 상태값을 정하고 detail 정보가 존재하는 경우 추가
        Health health =
                builder
                .withDetail("key1", "value1")
                .withDetail("key2", "value2")
                .build();
        ;

        return health;
    }

    private boolean getStatus() {
        return true;
//        if ( System.currentTimeMillis() % 2 == 0 ) return true;
//
//        return false;
    }
}
