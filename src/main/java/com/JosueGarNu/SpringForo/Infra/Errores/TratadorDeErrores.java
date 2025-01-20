package com.JosueGarNu.SpringForo.Infra.Errores;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AopInvocationException.class)
    public ResponseEntity tratarNulos() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        List<DatosError> errores = e.getFieldErrors().stream().map(DatosError::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private record DatosError(String campo, String mensajeError) {
        public DatosError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
