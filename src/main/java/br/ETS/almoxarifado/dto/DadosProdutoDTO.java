package br.ETS.almoxarifado.dto;

public record DadosProdutoDTO(
        int id,
        String produto,
        String partNumber,
        String divisao,
        int quantidade
) {
}
