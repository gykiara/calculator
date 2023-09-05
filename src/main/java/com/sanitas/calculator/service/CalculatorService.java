package com.sanitas.calculator.service;

import com.sanitas.calculator.model.ResponseDTO;

import java.math.BigDecimal;

public interface CalculatorService {

    /**
     * Applies the addition and returns the result of the operation.
     *
     * @param firstNumber  First number for calculation
     * @param secondNumber Second number for calculation
     * @return the result
     */
    ResponseDTO applyAddition(BigDecimal firstNumber, BigDecimal secondNumber);

    /**
     * Applies the subtraction and returns the result of the operation.
     *
     * @param firstNumber  First number for calculation
     * @param secondNumber Second number for calculation
     * @return the result
     */
    ResponseDTO applySubtraction(BigDecimal firstNumber, BigDecimal secondNumber);
}
