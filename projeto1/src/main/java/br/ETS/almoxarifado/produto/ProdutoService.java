package br.ETS.almoxarifado.produto;

import br.ETS.almoxarifado.RegraAplicacaoException;
import br.ETS.almoxarifado.connection.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;

public class ProdutoService {

    // criação da Lista de produtos do tipo Produto(entidade)
    private ArrayList<Produto> produtos = new ArrayList<>();

    private ConnectionFactory connectionFactory;

    public ProdutoService(){
        this.connectionFactory = new ConnectionFactory();
    }


    // método de adição de produtos
    public void adicionarNovoProduto(DadosProdutoDTO dadosProdutoDTO){
        var produto = new Produto(dadosProdutoDTO);

        if (produtos.contains(produto)){
            throw new RegraAplicacaoException("Já existe um produto com esse ID");
        }

        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).salvar(dadosProdutoDTO);
    }

    //método para exibir a lista de produtos do almoxarifado
    public ArrayList<Produto> exibirProdutosAlmoxarifado(){
        Connection connection = connectionFactory.recuperarConexao();
        return new ProdutoDAO(connection).listar();
    }

    // primeira forma de encontrar o produto pelo id
//    public Produto encontrarProdutoPeloID(int id){
//        for (Produto produto: produtos){
//            if(produto.getId() == id){
//                return produto;
//            }
//        }
//        throw new RegraAplicacaoException("Produto com este Id não foi encontrado");
//    }

    // segunda forma de encontrar o produto pelo id
    // o .stream que foi usado serve par manipular arrays, o filter para filtrar a partir de um parâmetro
    public Produto encontrarProdutoPeloID(int id){
        Connection connection = connectionFactory.recuperarConexao();
        Produto produto = new ProdutoDAO(connection).listarPorID(id);

        if (produto != null){
            return produto;
        } else {
            throw new RegraAplicacaoException("Não existe produto com este ID");
        }
    }

    // Atualizar a quantidade de produtos (adicionar + produtos)
    public void adicionarQuantidadeProduto(int id, int quantidade){
        var produto = encontrarProdutoPeloID(id);

        if (quantidade <= 0){
            throw new RegraAplicacaoException("Quantidade a ser adicionada deve ser maior que zero");
        }

        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() + quantidade);
    }

    // Atualizar a quantidade de produtos (subtrair produtos)
    public void removerQuantidadeProduto(int id, int quantidade){
        var produto = encontrarProdutoPeloID(id);

        if (quantidade <= 0){
            throw new RegraAplicacaoException("Quantidade a ser removida deve ser maior que zero");
        } else if (quantidade > produto.getQuantidade()) {
            throw new RegraAplicacaoException("A quantidade a ser removida não pode ser maior que a quantidade atual do estoque");
        }

        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() - quantidade);
    }

    // Remoção do produto por id da lista de produtos
    public void removerProdutoAlmoxarifado(int id){
        if (encontrarProdutoPeloID(id) != null){
            Connection connection = connectionFactory.recuperarConexao();
            new ProdutoDAO(connection).deletar(id);
        } else {
            throw new RegraAplicacaoException("Não foi encontrado produto com esse ID");
        }
    }


}
