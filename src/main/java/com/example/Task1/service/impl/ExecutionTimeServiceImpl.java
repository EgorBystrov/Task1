package com.example.Task1.service.impl;

import com.example.Task1.entity.Method;
import com.example.Task1.entity.TrackTime;
import com.example.Task1.repository.MethodRepository;
import com.example.Task1.repository.TrackTimeRepository;
import com.example.Task1.service.ExecutionTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ExecutionTimeServiceImpl implements ExecutionTimeService {
    @Autowired
    private final TrackTimeRepository trackTimeRepository;
    @Autowired
    private final MethodRepository methodRepository;

    public ExecutionTimeServiceImpl(TrackTimeRepository trackTimeRepository, MethodRepository methodRepository) {
        this.trackTimeRepository = trackTimeRepository;
        this.methodRepository = methodRepository;
    }
    @Override
    public void saveExecutionTime(String methodName, long executionTime) {
        Method method = findOrCreateMethod(methodName);

        if (method.getTrackTimeList() == null) {
            method.setTrackTimeList(new ArrayList<>());
        }
        TrackTime trackTime = new TrackTime(method, executionTime);
        trackTimeRepository.save(trackTime);

        method.getTrackTimeList().add(trackTime);
        methodRepository.save(method);
    }

    @Override
    public Method findOrCreateMethod(String methodName) {
        Optional<Method> method = methodRepository.findMethodByName(methodName);
        if (method.isPresent()) {
            return method.get();
        }
        Method newMethod = new Method(methodName);
        methodRepository.save(newMethod);
        return newMethod;
    }
}



