package br.ETS.almoxarifado.produto;

import java.util.Objects;


public class Produto {
    private int id;
    private String produto;
    private String partNumber;
    private String divisao;
    private int quantidade;


    // construtor utilizando o DTO
    public Produto(DadosProdutoDTO dadosProdutoDTO){
        this.id = dadosProdutoDTO.id();
        this.produto = dadosProdutoDTO.produto();
        this.partNumber = dadosProdutoDTO.partNumber();
        this.divisao = dadosProdutoDTO.divisao();
        this.quantidade = dadosProdutoDTO.quantidade();
    }
    //
    // equals and hashcode = serve para comparação ou ordenação de objetos, necessita de um critério para que seja feito isso
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // getter e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", produto='" + produto + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", divisao='" + divisao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
