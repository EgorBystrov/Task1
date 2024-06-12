package com.example.Task1.service;

import com.example.Task1.dto.AllMethodsDto;

import java.util.List;

public interface ExecutionStatisticsService {
    public long getAverageExecutionTime(String methodName);
    public long getTotalExecutionTime(String methodName);
    public List<AllMethodsDto> getAllMethods();

}
