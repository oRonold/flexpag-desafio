package br.com.flexpag.desafio.service;

import br.com.flexpag.desafio.dto.ChangeDateDTO;
import br.com.flexpag.desafio.dto.PaymentDTO;
import br.com.flexpag.desafio.infrastructure.exceptions.ExceptionEntityNotFound;
import br.com.flexpag.desafio.model.Payment;
import br.com.flexpag.desafio.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment not found"));
    }

    public Payment changeDate(ChangeDateDTO dto, Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment not found"));
        payment.setDateTime(dto.dateTime());
        return payment;
    }

    public void excludePayment(Long id) {
        if(!paymentRepository.existsById(id)){
            throw new EntityNotFoundException("Payment not found");
        }
        paymentRepository.deleteById(id);
    }
}
