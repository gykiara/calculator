package com.sanitas.calculator.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

    @Bean
    public TracerImpl tracer() {
        return new TracerImpl();
    }
}
