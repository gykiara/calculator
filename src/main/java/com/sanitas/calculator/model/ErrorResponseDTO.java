package com.sanitas.calculator.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ErrorResponseDTO implements Serializable {

    private String code;
    private String message;
}
