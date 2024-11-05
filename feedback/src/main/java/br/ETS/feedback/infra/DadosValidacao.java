package br.ETS.feedback.infra;

import org.springframework.validation.FieldError;

public record DadosValidacao(
        String field,
        String message
) {

    public DadosValidacao(FieldError fieldError){
        this(fieldError.getField(),fieldError.getDefaultMessage());
    }
}
