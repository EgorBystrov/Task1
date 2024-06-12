package com.example.Task1.aspect;

import com.example.Task1.annotation.TrackAsyncTime;
import com.example.Task1.annotation.TrackTime;
import com.example.Task1.exception.ServerException;
import com.example.Task1.service.impl.ExecutionTimeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@Slf4j
public class TrackTimeAspect {
    @Autowired
    private ExecutionTimeServiceImpl executionTimeServiceImpl;

    @Around("@annotation(trackTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint, TrackTime trackTime) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        executionTimeServiceImpl.saveExecutionTime(methodName, executionTime);
        log.info("Method {} was completed in {} ms", methodName, executionTime);

        return proceed;
    }

    @Around("@annotation(trackAsyncTime)")
    public Object trackAsyncTime(ProceedingJoinPoint joinPoint, TrackAsyncTime trackAsyncTime) throws Throwable {
        long start = System.currentTimeMillis();

        return CompletableFuture.supplyAsync(() -> {
                    try {
                        return joinPoint.proceed();
                    } catch (Throwable e) {
                        throw new ServerException(e.getMessage());
                    }
                })
                .thenApply(result -> {
                    long executionTime = System.currentTimeMillis() - start;
                    String methodName = joinPoint.getSignature().getName();
                    executionTimeServiceImpl.saveExecutionTime(methodName, executionTime);
                    log.info("Method {} was completed in {} ms", methodName, executionTime);
                    return result;
                })
                .exceptionally(e -> {
                    throw new ServerException(e.getMessage());
                });
    }
}
