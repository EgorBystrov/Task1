package com.example.Task1.controller;

import com.example.Task1.controller.api.StatisticsControllerApi;
import com.example.Task1.dto.AllMethodsDto;
import com.example.Task1.service.ExecutionStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController implements StatisticsControllerApi {

    @Autowired
    private ExecutionStatisticsService executionStatisticsService;

    @GetMapping("/average-time/{methodName}")
    @Override
    public ResponseEntity<Long> getAverageExecutionTime(@PathVariable("methodName") String methodName) {
        return ResponseEntity.ok(executionStatisticsService.getAverageExecutionTime(methodName));
    }

    @GetMapping("/total-time/{methodName}")
    @Override
    public ResponseEntity<Long> getTotalExecutionTime(@PathVariable("methodName") String methodName) {
        return ResponseEntity.ok(executionStatisticsService.getTotalExecutionTime(methodName));
    }

    @GetMapping("/all-methods")
    @Override
    public ResponseEntity<List<AllMethodsDto>> getAllMethods() {
        return ResponseEntity.ok(executionStatisticsService.getAllMethods());
    }
}
