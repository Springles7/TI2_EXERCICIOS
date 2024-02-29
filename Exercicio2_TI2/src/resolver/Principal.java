package resolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TI2";
        String usuario = "postgres";
        String senha = "Pedro";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PessoaDAO pessoaDAO = new PessoaDAO(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Listar Pessoas");
                System.out.println("2. Inserir Pessoa");
                System.out.println("3. Excluir Pessoa");
                System.out.println("4. Atualizar Pessoa");
                System.out.println("5. Sair");

                System.out.print("Escolha a opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        List<Pessoa> pessoas = pessoaDAO.listar();
                        for (Pessoa pessoa : pessoas) {
                            System.out.println("ID: " + pessoa.getId() + ", Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
                        }
                        break;

                    case 2:
                        scanner.nextLine(); 
                        System.out.print("Digite o nome da pessoa: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a idade da pessoa: ");
                        int idade = scanner.nextInt();
                        
                        Pessoa novaPessoa = new Pessoa();
                        novaPessoa.setNome(nome);
                        novaPessoa.setIdade(idade);

                        pessoaDAO.inserir(novaPessoa);
                        System.out.println("Pessoa inserida com sucesso!");
                        break;

                    case 3:
                        // Ainda nao fiz para remover
                        break;

                    case 4:
                        // Ainda nao fiz para atualizar
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
