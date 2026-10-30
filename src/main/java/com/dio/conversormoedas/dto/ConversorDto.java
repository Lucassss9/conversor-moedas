package com.dio.conversormoedas.dto;

import java.math.BigDecimal;

public record ConversorDto(String code, String name, BigDecimal bid) {
}
