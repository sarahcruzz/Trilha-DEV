package br.ETS.feedback.model.aprendiz.dto;

import br.ETS.feedback.model.Curso;
import br.ETS.feedback.model.instrutor.dto.DadosInformacoes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAprendiz(
        @NotNull
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        DadosInformacoesAprendiz informacoes
) {
}
