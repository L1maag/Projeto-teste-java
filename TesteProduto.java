


import java.util.ArrayList;
import java.util.Scanner;

public class TesteProduto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Vender Produto");
            System.out.println("4 - Repor Estoque");
            System.out.println("5 - Aplicar Desconto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Disponível (true/false): ");
                    boolean disponivel = scanner.nextBoolean();

                    Produto novoProduto = new Produto(nome, preco, quantidade, disponivel);
                    produtos.add(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== Lista de Produtos ===");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println("Código: " + i);
                            System.out.println(produtos.get(i).exibirDetalhes());
                            System.out.println("-----------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o código do produto que deseja vender: ");
                    int codigoVenda = scanner.nextInt();
                    if (codigoVenda >= 0 && codigoVenda < produtos.size()) {
                        System.out.print("Quantidade para vender: ");
                        int qtdVenda = scanner.nextInt();
                        produtos.get(codigoVenda).venderProduto(qtdVenda);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o código do produto que deseja repor: ");
                    int codigoRepor = scanner.nextInt();
                    if (codigoRepor >= 0 && codigoRepor < produtos.size()) {
                        System.out.print("Quantidade para repor: ");
                        int qtdRepor = scanner.nextInt();
                        produtos.get(codigoRepor).reporEstoque(qtdRepor);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o código do produto que deseja aplicar desconto: ");
                    int codigoDesconto = scanner.nextInt();
                    if (codigoDesconto >= 0 && codigoDesconto < produtos.size()) {
                        System.out.print("Percentual de desconto: ");
                        double desconto = scanner.nextDouble();
                        produtos.get(codigoDesconto).aplicarDesconto(desconto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
