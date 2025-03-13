package br.com.flexpag.desafio.dto;

import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.model.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentDetailsDTO(Long id, BigDecimal value,
                                @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                LocalDateTime dateTime, PaymentStatus status) {

    public PaymentDetailsDTO(Payment payment){
        this(payment.getId(), payment.getAmount(), payment.getDateTime(), payment.getStatus());
    }
}
