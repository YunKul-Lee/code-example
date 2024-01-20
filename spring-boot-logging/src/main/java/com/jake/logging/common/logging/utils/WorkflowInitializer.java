package com.jake.logging.common.logging.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class WorkflowInitializer {

    public static class Builder {
        public WorkflowInitializer build() {
            return new WorkflowInitializer();
        }
    }

    public Runnable initFlow() {
        return () -> {
            IntStream.range(1, 100000).forEach(value -> {
                try {
                    MDC.put("threadName", Thread.currentThread().getName());
                    MDC.put("thread.id", String.valueOf(Thread.currentThread().threadId()));
                    if( value % 11 == 0) {
                        throw new Exception("Dividable by 11 Error");
                    }
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception e) {
                    log.info("Flow: {}", value);
                } finally {
                    MDC.clear();
                }
            });
        };
    }
}
