package br.com.flexpag.desafio.service;

import br.com.flexpag.desafio.dto.PaymentDTO;
import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment schedulePayment(PaymentDTO dto){
        Payment payment = new Payment(dto);
        return paymentRepository.save(payment);
    }

    public Payment consultStatus(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }
}
