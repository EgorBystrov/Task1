package com.example.Task1.controller.api;

import com.example.Task1.dto.AllMethodsDto;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "statistic_methods")
public interface StatisticsControllerApi {

    @Operation(summary = "Getting the average execution time of a method")
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
    ResponseEntity<Long> getAverageExecutionTime(@PathVariable("methodName") String methodName);

    @Operation(summary = "Getting the total execution time of the method for all time")
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
    ResponseEntity<Long> getTotalExecutionTime(@PathVariable("methodName") String methodName);

    @Operation(summary = "Getting a list of method names")
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
    ResponseEntity<List<AllMethodsDto>> getAllMethods();
}
