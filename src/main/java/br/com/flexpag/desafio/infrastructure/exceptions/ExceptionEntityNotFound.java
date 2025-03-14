package br.com.flexpag.desafio.infrastructure.exceptions;

import br.com.flexpag.desafio.dto.ExceptionsMessagesDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionEntityNotFound {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionsMessagesDTO> entityNotFound(EntityNotFoundException e){
        ExceptionsMessagesDTO dto = new ExceptionsMessagesDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ExceptionsMessagesDTO> illegalState(IllegalStateException e){
        ExceptionsMessagesDTO dto = new ExceptionsMessagesDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dto);
    }
}
