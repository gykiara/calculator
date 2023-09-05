package com.sanitas.calculator.config;

import com.sanitas.calculator.model.ErrorResponseDTO;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@AllArgsConstructor
@ControllerAdvice
public class CalculatorExceptionHandler {

    private TracerImpl tracer;

    @ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponseDTO> badRequest() {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message("Parameters are required and should be numbers")
                .build();
        tracer.trace(errorResponseDTO);
        return ResponseEntity.badRequest().body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> otherException() {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message("Uncontrolled error")
                .build();
        tracer.trace(errorResponseDTO);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }
}
