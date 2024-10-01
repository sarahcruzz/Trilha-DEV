package br.ETS.almoxarifado;

import br.ETS.almoxarifado.services.ProdutoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AlmoxarifadoApplication {
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
							
							R:
    			
							""");
		return Integer.parseInt(scanner.nextLine());
	}

	public static void main(String[] args) {
		var opcao = exibirMenu();
	}


}
