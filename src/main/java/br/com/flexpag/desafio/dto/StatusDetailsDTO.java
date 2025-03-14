package br.com.flexpag.desafio.dto;

import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.model.PaymentStatus;

public record StatusDetailsDTO(PaymentStatus status) {

    public StatusDetailsDTO(Payment payment){
        this(payment.getStatus());
    }
}
