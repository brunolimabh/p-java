package org.example;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();

        int opcao = 0;
        do {
            System.out.println("""
                    1 - Adicionar Livro
                    2 - Adicionar DVD
                    3 - Adicionar Serviço
                    4 - Exibir Itens do Carrinho
                    5 - Exibir Total Vendas
                    6 - Sair
                    """);
            opcao = inputNumber.nextInt();
            if (opcao == 1){
                System.out.println("Informe o código:");
                Integer codigo = inputNumber.nextInt();
                System.out.println("Informe o preço:");
                Integer precoCusto = inputNumber.nextInt();
                System.out.println("Informe o nome:");
                String nome = inputString.nextLine();
                System.out.println("Informe o autor:");
                String autor = inputString.nextLine();
                System.out.println("Informe o ISBN:");
                String isbn = inputString.nextLine();

                Livro livro = new Livro(codigo,precoCusto,nome,autor,isbn);
                carrinho.adicionarVendavel(livro);
                System.out.println("Livro %s adicionado com sucesso".formatted(nome));
            } else if (opcao == 2) {
                System.out.println("Informe o código:");
                Integer codigo = inputNumber.nextInt();
                System.out.println("Informe o preço:");
                Integer precoCusto = inputNumber.nextInt();
                System.out.println("Informe o nome:");
                String nome = inputString.nextLine();
                System.out.println("Informe a gravadora:");
                String gravadora = inputString.nextLine();

                DVD dvd = new DVD(codigo,precoCusto,nome,gravadora);
                carrinho.adicionarVendavel(dvd);
                System.out.println("DVD %s adicionado com sucesso".formatted(nome));
            } else if (opcao == 3) {
                System.out.println("Informe a descricao:");
                String descricao = inputString.nextLine();
                System.out.println("Informe o código:");
                Integer codigo = inputNumber.nextInt();
                System.out.println("Informe a quantidade de horas:");
                Integer quantHoras = inputNumber.nextInt();
                System.out.println("Informe o valor da hora:");
                Double valorHora = inputNumber.nextDouble();

                Servico servico = new Servico(descricao,codigo,quantHoras,valorHora);
                carrinho.adicionarVendavel(servico);
                System.out.println("Serviço %s adicionado com sucesso".formatted(descricao));
            } else if (opcao == 4) {
                carrinho.exibirItensCarrinho();
            } else if (opcao == 5) {
                System.out.println("O valor total: R$%.2f".formatted(carrinho.calculaTotalVenda()));
            } else if (opcao == 6) {
                System.out.println("Carrinho encerrado\nVolte sempre");
            } else {
                System.out.println("Insira um numero válido");
            }
        } while (opcao != 6);

    }
}