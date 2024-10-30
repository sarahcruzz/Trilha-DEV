package br.ETS.feedback.instrutor.dto;

import br.ETS.feedback.instrutor.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(
        @NotNull
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        DadosInformacoes informacoes
) {
}
