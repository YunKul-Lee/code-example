package com.jake.actuator.gauge;

import org.springframework.stereotype.Service;

@Service
public class QueueManager {

    public long getQueueSize() {
        return System.currentTimeMillis();
    }
}
