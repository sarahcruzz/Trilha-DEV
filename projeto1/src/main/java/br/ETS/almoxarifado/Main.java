package br.ETS.almoxarifado;

import br.ETS.almoxarifado.produto.DadosProdutoDTO;
import br.ETS.almoxarifado.produto.ProdutoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
	private static ProdutoService produtoService = new ProdutoService();
	private static Scanner scanner = new Scanner(System.in);
	private static int exibirMenu(){
		System.out.println("Almoxarifado ETS");
		System.out.println("""
							Selecione uma opção:
							1 - Inserir novo produto no almoxarifado
							2 - Listar os produtos do almoxarifado
							3 - Adicionar determinada quantidade de um produto no almoxarifado
							4 - Remover determinada quantidade de um produto no almoxarifado
							5 - Remover um produto do almoxarifado
							6 - Encerrar aplicação
							
							R:    		\t
							""");
		return Integer.parseInt(scanner.nextLine());
	}

	public static void main(String[] args) {
		var opcao = exibirMenu();

		while(opcao != 6){
			try{
				switch (opcao){
					case 1 -> adicionarNovoProduto();
					case 2 -> exibirProdutosCadastrados();
					case 3 -> adicionarQuantidadeProduto();
					case 4 -> removerQuantidadeProduto();
					case 5 -> removerProdutoAlmoxarifado();
				}
			} catch (RegraAplicacaoException e){
				System.out.println(e.getMessage());
				System.out.println("Pressione ENTER para voltar ao menu principal");
				scanner.nextLine();
			}
			opcao = exibirMenu();
		}

	}

	private static void adicionarNovoProduto(){
		System.out.println("Insira o ID do produto que deseja cadastrar: ");
		var id = Integer.parseInt(scanner.nextLine());

		System.out.println("Insira o nome do produto que deseja cadastrar: ");
		var produto = scanner.nextLine();

		System.out.println("Insira o PARTNUMBER do produto que deseja cadastrar: ");
		var partnumber = scanner.nextLine();

		System.out.println("Insira a divisão do produto que deseja cadastrar: ");
		var divisao = scanner.nextLine();

		System.out.println("Insira a quantidade desse produto: ");
		var quantidade = Integer.parseInt(scanner.nextLine());

		produtoService.adicionarNovoProduto(new DadosProdutoDTO(id, produto, partnumber, divisao, quantidade));
		System.out.printf("O produto %s foi cadastrado com sucesso \n", produto);
	}

	private static void exibirProdutosCadastrados(){
		System.out.println("Os produtos cadastrados são: ");
		var produtos = produtoService.exibirProdutosAlmoxarifado();
		produtos.forEach(System.out::println);
		System.out.println("Pressione ENTER para voltar ao menu principal...");
		scanner.nextLine();
	}

	private static  void adicionarQuantidadeProduto(){
		System.out.println("Digite o ID do produto que deseja adicionar: ");
		var id  = Integer.parseInt(scanner.nextLine());

		System.out.println("Digite a quantidade que deseja inserir desse produto: ");
		var quantidade = Integer.parseInt(scanner.nextLine());

		produtoService.adicionarQuantidadeProduto(id, quantidade);
		System.out.printf("\nA quantidade de %d foi adicionada ao produto com ID %d", quantidade, id);
		System.out.println("Pressione ENTER para voltar ao menu principal...");
		scanner.nextLine();
	}

	private static void removerQuantidadeProduto(){
		System.out.println("Digite o ID do produto que deseja remover: ");
		var id  = Integer.parseInt(scanner.nextLine());

		System.out.println("Digite a quantidade que deseja remover desse produto: ");
		var quantidade = Integer.parseInt(scanner.nextLine());

		produtoService.removerQuantidadeProduto(id, quantidade);
		System.out.printf("\nA quantidade de %d foi removida do produto com ID %d", quantidade, id);
		System.out.println("Pressione ENTER para voltar ao menu principal...");
		scanner.nextLine();
	}

	private static void removerProdutoAlmoxarifado(){
		System.out.println("Informe o ID do produto que você deseja remover do almoxarifado: ");
		var id  = Integer.parseInt(scanner.nextLine());

		produtoService.removerProdutoAlmoxarifado(id);
		System.out.printf("\nO produto com ID %d foi removido com sucesso!", id);
		System.out.println("Pressione ENTER para voltar ao menu principal...");
		scanner.nextLine();
	}


}
