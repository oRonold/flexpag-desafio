package br.com.flexpag.desafio.controller;

import br.com.flexpag.desafio.dto.ChangeDateDTO;
import br.com.flexpag.desafio.dto.PaymentDTO;
import br.com.flexpag.desafio.dto.PaymentDetailsDTO;
import br.com.flexpag.desafio.dto.StatusDetailsDTO;
import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/status/{id}")
    public ResponseEntity<StatusDetailsDTO> consultStatus(@PathVariable Long id){
        Payment payment = paymentService.consultStatus(id);
        return ResponseEntity.ok(new StatusDetailsDTO(payment));
    }

    @PutMapping("/pay-amount/{id}")
    @Transactional
    public ResponseEntity<PaymentDetailsDTO> payAmount(@PathVariable Long id){
        Payment payment = paymentService.payAmount(id);
        return ResponseEntity.ok(new PaymentDetailsDTO(payment));
    }

    @PutMapping("/change-date/{id}")
    @Transactional
    public ResponseEntity<PaymentDetailsDTO> changeDate(@RequestBody ChangeDateDTO dto, @PathVariable Long id){
        Payment payment = paymentService.changeDate(dto, id);
        return ResponseEntity.ok(new PaymentDetailsDTO(payment));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excludePayment(@PathVariable Long id){
        paymentService.excludePayment(id);
        return ResponseEntity.noContent().build();
    }
}
