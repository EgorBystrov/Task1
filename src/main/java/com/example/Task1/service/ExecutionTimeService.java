package com.example.Task1.service;

import com.example.Task1.entity.Method;
import com.example.Task1.entity.TrackTime;

import java.util.ArrayList;
import java.util.Optional;

public interface ExecutionTimeService {
    public void saveExecutionTime(String methodName, long executionTime);

    public Method findOrCreateMethod(String methodName);
}
