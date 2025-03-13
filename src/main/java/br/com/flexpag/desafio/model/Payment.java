package br.com.flexpag.desafio.model;

import br.com.flexpag.desafio.dto.PaymentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private PaymentStatus status;

    public Payment(PaymentDTO dto){
        this.amount = dto.value();
        this.dateTime = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
    }
}
