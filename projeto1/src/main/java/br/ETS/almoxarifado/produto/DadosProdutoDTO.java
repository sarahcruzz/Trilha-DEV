package br.ETS.almoxarifado.produto;

public record DadosProdutoDTO(
        int id,
        String produto,
        String partNumber,
        String divisao,
        int quantidade
) {
}
