package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputS = new Scanner(System.in);
        Scanner inputN = new Scanner(System.in);
        Executaveis acao = new Executaveis();
        Integer opcaoMenu = 0;

        do {
            System.out.println("""
                    +-------------------------+
                    | Livraria SPTECH         |
                    +-------------------------+
                    | 1) Cadastrar livro      |
                    | 2) Exibir livros        |
                    | 3) Atualizar livro      |
                    | 4) Remover livro        |
                    | 5) Buscar por nome      |
                    | 6) Sair                 |
                    +-------------------------+
                    """);
            opcaoMenu = inputN.nextInt();

            if (opcaoMenu == 1) {
                System.out.println("CADASTRAR LIVRO");
                System.out.println("Nome do livro:");
                String nome = inputS.nextLine();
                System.out.println("Preço:");
                Double preco = inputN.nextDouble();
                acao.addLivro(nome,preco);
            } else if (opcaoMenu == 2) {
                acao.exibirLivros();
            } else if (opcaoMenu == 3) {
                System.out.println("ATUALIZAR LIVRO");
                System.out.println("ID do livro:");
                Integer id = inputN.nextInt();
                System.out.println("Nome do livro:");
                String nome = inputS.nextLine();
                System.out.println("Preço:");
                Double preco = inputN.nextDouble();
                acao.attLivro(id,nome,preco);
            } else if (opcaoMenu == 4) {
                System.out.println("REMOVER LIVRO");
                System.out.println("ID do livro:");
                Integer id = inputN.nextInt();
                acao.dltLivro(id);
            } else if (opcaoMenu == 5) {
                System.out.println("BUSCAR POR NOME");
                System.out.println("Nome do livro:");
                String nome = inputS.nextLine();
                acao.buscarNome(nome);
            } else if (opcaoMenu == 6) {
                System.out.println("Até mais");
            } else {
                System.out.println("Por favor, insira uma opção válida\n");
            }

        }while (opcaoMenu != 6);
    }
}