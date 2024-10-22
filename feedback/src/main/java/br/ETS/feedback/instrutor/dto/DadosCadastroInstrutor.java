package br.ETS.feedback.instrutor.dto;

public record DadosCadastroInstrutor(
        String nome,
        String email,
        String edv,
        String curso,
        DadosInformacoes dadosInformacoes
) {
}
