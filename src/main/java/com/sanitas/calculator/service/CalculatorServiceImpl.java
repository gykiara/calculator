package com.sanitas.calculator.service;

import com.sanitas.calculator.model.ResponseDTO;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class CalculatorServiceImpl implements CalculatorService {

    TracerImpl tracerAPI;

    @Override
    public ResponseDTO applyAddition(BigDecimal firstNumber, BigDecimal secondNumber) {

        BigDecimal result = firstNumber.add(secondNumber);
        tracerAPI.trace("AdditionServiceImpl - addition result: " + result);
        return ResponseDTO.builder().result(result).build();
    }

    @Override
    public ResponseDTO applySubtraction(BigDecimal firstNumber, BigDecimal secondNumber) {

        BigDecimal result = firstNumber.subtract(secondNumber);
        tracerAPI.trace("SubtractionServiceImpl - result subtraction: " + result);
        return ResponseDTO.builder().result(result).build();
    }
}
