package com.sanitas.calculator.controller;

import com.sanitas.calculator.config.CalculatorExceptionHandler;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.service.CalculatorServiceImpl;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CalculatorControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        TracerImpl tracer = new TracerImpl();
        CalculatorService service = new CalculatorServiceImpl(tracer);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new CalculatorController(service, tracer))
                .setControllerAdvice(new CalculatorExceptionHandler(tracer))
                .build();
    }

    @Test
    void given_BothParamsCorrect_When_Addition_Then_ReturnsStatusIsOkAndContentIsAdditionResult() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/addition")
                                .param("firstNumber", "1")
                                .param("secondNumber", "1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().json("{\"result\":2}")
                );
    }

    @Test
    void given_BothParamsCorrect_When_Subtraction_Then_ReturnsStatusIsOkAndContentIsSubtractionResult() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/subtraction")
                                .param("firstNumber", "1")
                                .param("secondNumber", "1"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        content().json("{\"result\":0}")
                );
    }

    @Test
    void given_OneParamIsString_When_Subtraction_Then_ReturnsStatusIsBadRequestAndContentIsErrorMessage() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/subtraction")
                                .param("firstNumber", "1")
                                .param("secondNumber", "test"))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().json("{\"code\":\"BAD_REQUEST\",\"message\":\"Parameters are required and should be numbers\"}")
                );
    }

    @Test
    void given_OneParamIsNull_When_Addition_Then_ReturnsStatusIsBadRequestAndContentIsErrorMessage() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/addition")
                                .param("firstNumber", "1"))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().json("{\"code\":\"BAD_REQUEST\",\"message\":\"Parameters are required and should be numbers\"}")
                );
    }
}