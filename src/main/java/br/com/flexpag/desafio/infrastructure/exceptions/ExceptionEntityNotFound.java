package br.com.flexpag.desafio.infrastructure.exceptions;

import br.com.flexpag.desafio.dto.EntityNotFoundDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionEntityNotFound {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundDTO> entityNotFound(EntityNotFoundException e){
        EntityNotFoundDTO dto = new EntityNotFoundDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
}
