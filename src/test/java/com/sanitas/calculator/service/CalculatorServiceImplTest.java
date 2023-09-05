package com.sanitas.calculator.service;

import com.sanitas.calculator.model.ResponseDTO;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplTest {

    private CalculatorServiceImpl service;

    @BeforeEach
    void init() {
        TracerImpl tracerAPI = new TracerImpl();
        service = new CalculatorServiceImpl(tracerAPI);
    }

    @Test
    void given_BothParamsCorrect_When_ApplyAddition_Then_ReturnsResultCorrect() {
        ResponseDTO actualResponse = service.applyAddition(BigDecimal.ONE, BigDecimal.ONE);
        assertEquals(new BigDecimal(2), actualResponse.getResult());
    }

    @Test
    void given_BothParamsCorrect_When_ApplySubtraction_Then_ReturnsResultCorrect() {
        ResponseDTO actualResponse = service.applySubtraction(BigDecimal.ONE, BigDecimal.ONE);
        assertEquals(new BigDecimal(0), actualResponse.getResult());
    }

}