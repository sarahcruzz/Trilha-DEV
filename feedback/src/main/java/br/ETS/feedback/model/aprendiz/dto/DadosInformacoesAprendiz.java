package br.ETS.feedback.model.aprendiz.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosInformacoesAprendiz(
        @NotBlank
        String trilha,

        @NotBlank
        String faculdade,
        @NotBlank
        String turma
) {
}
