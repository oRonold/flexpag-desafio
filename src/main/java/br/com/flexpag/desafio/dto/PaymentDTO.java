package br.com.flexpag.desafio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentDTO(BigDecimal value,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                         LocalDateTime dateTime) {
}
