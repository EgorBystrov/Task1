package com.example.Task1.service.impl;

import com.example.Task1.annotation.TrackAsyncTime;
import com.example.Task1.annotation.TrackTime;
import com.example.Task1.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    @TrackTime
    public void syncLongCalculation() {
        long sum = 0;
        for (long i = 1; i <= 1_000_000_000; i++) {
            sum += i;
        }
    }

    @Override
    @TrackAsyncTime
    public void asyncLongCalculation() {
        long sum = 0;
        for (long i = 1; i <= 1_000_000_000; i++) {
            sum += i;
        }
    }
}
