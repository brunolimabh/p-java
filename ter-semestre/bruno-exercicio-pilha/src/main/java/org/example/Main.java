package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repositorio rep = new Repositorio();
        Scanner leitorNumber = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);
        int opcao = 0;

        Funcionario func1 = new Funcionario("bruno", 1, 9.0);
        Funcionario func2 = new Funcionario("caio", 2, 11.0);
        Funcionario func3 = new Funcionario("paulo", 3, 10.0);
        rep.salvar(func1);
        rep.salvar(func2);
        rep.salvar(func3);

        do {
            System.out.println("""
                    1 - Salvar objeto
                    2 - Deletar objeto
                    3 - Exibir
                    4 - Desfazer
                    5 - Fim
                    """);
            opcao = leitorNumber.nextInt();

            if (opcao == 1) {
                System.out.println("Digite o nome do funcionário:");
                String nome = leitorString.nextLine();

                System.out.println("Digite a quantidade de filhos do funcionário:");
                int filhos = leitorNumber.nextInt();

                System.out.println("Digite o salário do funcionário:");
                double salario = leitorNumber.nextDouble();

                Funcionario func = new Funcionario(nome, filhos, salario);

                rep.salvar(func);

            } else if (opcao == 2) {
                System.out.println("Digite o id do funcionario a ser deletado:");
                int id = leitorNumber.nextInt();
                rep.deletar(id);

            } else if (opcao == 3) {
                rep.exibir();

            } else if (opcao == 4) {
                rep.desfazer();

            } else if (opcao == 5) {
                System.out.println("Até a próxima");

            } else {
                System.out.println("Digite uma opção válida");

            }


        } while (opcao != 5);
    }
}