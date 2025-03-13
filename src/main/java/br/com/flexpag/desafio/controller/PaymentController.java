package br.com.flexpag.desafio.controller;

import br.com.flexpag.desafio.dto.PaymentDTO;
import br.com.flexpag.desafio.dto.PaymentDetailsDTO;
import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @Transactional
    public ResponseEntity<PaymentDetailsDTO> schedulePayment(@RequestBody PaymentDTO dto, UriComponentsBuilder builder){
        Payment payment = paymentService.schedulePayment(dto);
        URI uri = builder.path("/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaymentDetailsDTO(payment));
    }
}
