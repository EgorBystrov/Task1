package com.example.Task1.service.impl;

import com.example.Task1.dto.AllMethodsDto;
import com.example.Task1.entity.Method;
import com.example.Task1.entity.TrackTime;
import com.example.Task1.exception.ClientException;
import com.example.Task1.mapper.AllMethodsDtoMapper;
import com.example.Task1.repository.MethodRepository;
import com.example.Task1.service.ExecutionStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExecutionStatisticsServiceImpl implements ExecutionStatisticsService {
    @Autowired
    private final MethodRepository methodRepository;
    @Autowired
    private final AllMethodsDtoMapper allMethodsDtoMapper;

    public ExecutionStatisticsServiceImpl(MethodRepository methodRepository, AllMethodsDtoMapper allMethodsDtoMapper) {
        this.methodRepository = methodRepository;
        this.allMethodsDtoMapper = allMethodsDtoMapper;
    }

    @Override
    public long getAverageExecutionTime(String methodName) {
        Optional<Method> method = methodRepository.findMethodByName(methodName);

        if (method.isPresent()) {
            List<TrackTime> trackTimeList = method.get().getTrackTimeList();
            long sum = trackTimeList.stream()
                    .mapToLong(TrackTime::getExecutionTime).sum();
            return sum / trackTimeList.size();
        } else {
            throw new ClientException("The method named " + methodName + " was not found");
        }
    }

    @Override
    public long getTotalExecutionTime(String methodName) {
        Optional<Method> method = methodRepository.findMethodByName(methodName);

        if (method.isPresent()) {
            List<TrackTime> trackTimeList = method.get().getTrackTimeList();
            long sum = trackTimeList.stream()
                    .mapToLong(TrackTime::getExecutionTime).sum();
            return sum;
        } else {
            throw new ClientException("The method named " + methodName + " was not found");
        }
    }

    @Override
    public List<AllMethodsDto> getAllMethods() {
        List<Method> allMethodsList = methodRepository.findAll();
        return allMethodsList.stream()
                .map(allMethodsDtoMapper::allMethodsToDto)
                .collect(Collectors.toList());
    }
}
