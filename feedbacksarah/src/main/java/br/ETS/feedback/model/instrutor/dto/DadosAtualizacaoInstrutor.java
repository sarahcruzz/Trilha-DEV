package br.ETS.feedback.model.instrutor.dto;

import br.ETS.feedback.model.Curso;
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
