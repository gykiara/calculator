package com.sanitas.calculator.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ResponseDTO {

    private BigDecimal result;
}
