package com.sanitas.calculator.controller;

import com.sanitas.calculator.model.ResponseDTO;
import com.sanitas.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CalculatorController {

    private CalculatorService service;
    private TracerImpl tracer;

    @Operation(summary = "Get result of addition", description = "Returns the result of the operation SUM.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Call successfull.", content = @Content(schema = @Schema(implementation = BigDecimal.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request - Cannot perform the operation, some data is incorrect.",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/addition")
    public ResponseEntity<ResponseDTO> getResultAddition(@RequestParam BigDecimal firstNumber, @RequestParam BigDecimal secondNumber) {
        tracer.trace("CalculatorController - Addition");

        return ResponseEntity.ok(service.applyAddition(firstNumber, secondNumber));
    }

    @Operation(summary = "Get result of subtraction", description = "Returns the result of the operation SUBTRACT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Call successfull.", content = @Content(schema = @Schema(implementation = BigDecimal.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request - Cannot perform the operation, some data is incorrect.",
                    content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/subtraction")
    public ResponseEntity<ResponseDTO> getResultSubtraction(@RequestParam BigDecimal firstNumber, @RequestParam BigDecimal secondNumber) {
        tracer.trace("CalculatorController - Subtraction");
        return ResponseEntity.ok(service.applySubtraction(firstNumber, secondNumber));
    }
}
