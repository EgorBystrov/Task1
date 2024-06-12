package com.example.Task1.controller;

import com.example.Task1.controller.api.CalculationControllerApi;
import com.example.Task1.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
@RequiredArgsConstructor
public class CalculationController implements CalculationControllerApi {
    private final CalculationService calculationService;

    @GetMapping
    @Override
    public ResponseEntity<Void> calculateService(){
        calculationService.syncLongCalculation();
        calculationService.asyncLongCalculation();
        return ResponseEntity.ok().build();
    }
}
