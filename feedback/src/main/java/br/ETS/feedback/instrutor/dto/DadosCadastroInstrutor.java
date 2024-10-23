package br.ETS.feedback.instrutor.dto;

import br.ETS.feedback.instrutor.Curso;

public record DadosCadastroInstrutor(
        String nome,
        String email,
        String edv,
        Curso curso,
        DadosInformacoes dadosInformacoes
) {
}
