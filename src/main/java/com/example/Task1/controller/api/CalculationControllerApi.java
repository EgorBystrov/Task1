package com.example.Task1.controller.api;

import com.example.Task1.exception.ClientException;
import com.example.Task1.exception.ServerException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "calculation_method")
public interface CalculationControllerApi {
    @Operation(summary = "Saves the execution time of methods",
            description = "Starts the calculation of synchronous and asynchronous methods " +
                    "and records the time of their execution in the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful completion"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ClientException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ServerException.class))
            )
    })
    ResponseEntity<Void> calculateService();
}
