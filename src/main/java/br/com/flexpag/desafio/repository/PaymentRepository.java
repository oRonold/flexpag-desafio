package br.com.flexpag.desafio.repository;

import br.com.flexpag.desafio.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
