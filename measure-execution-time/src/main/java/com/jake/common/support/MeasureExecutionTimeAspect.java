package com.jake.common.support;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class MeasureExecutionTimeAspect {
    @Around("@annotation(com.jake.common.support.MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        try {
            return joinPoint.proceed();
        } finally {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();
            log.info("Method {}.{} Execution Time: {} ms", className, methodName, Duration.between(start, Instant.now()).toMillis());
        }
    }
}
