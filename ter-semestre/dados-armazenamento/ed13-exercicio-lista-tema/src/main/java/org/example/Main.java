package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaObj<Funcionario> funcionarios = new ListaObj<>(5);
//        Funcionario f1 = new Funcionario(1, "Bruno Henrique",  6, 0,10.430,1.82,72.4);
//        Funcionario f2 = new Funcionario(2, "Pedro Lima", 6, 1,4.290,1.80,59.2);
//        Funcionario f3 = new Funcionario(3, "Henrique Oliveira",  6, 3,6.180,1.69,64.6);
//        Funcionario f4 = new Funcionario(4, "Marcos Antonio", 6, 2,2.540,1.71,39.5);
//        Funcionario f5 = new Funcionario(5, "Marcelo Gonçalves", 6, 2,5.910,1.78,44.4);

        Scanner leitorNumber = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);
        
        System.out.println("Bem vindo a empresa do Bruno");
        int escolha = 0;
        do {
            System.out.println("""
                    Escolha a opção desejada: (digite 1,2 ou 3)
                    1 - Adicionar um funcionario
                    2 - Exibir Relatório
                    3 - Sair
                    """);
            escolha = leitorNumber.nextInt();

            if (escolha == 1){
                int identificador;
                String nome;
                int cursos;
                int filhos;
                double salario;
                double altura;
                double peso;

                System.out.println("Digite o identificador: ");
                identificador = leitorNumber.nextInt();
                System.out.println("Digite o nome: ");
                nome = leitorString.nextLine();
                System.out.println("Digite a quantidade de cursos: ");
                cursos = leitorNumber.nextInt();
                System.out.println("Digite a quantidade de filhos: ");
                filhos = leitorNumber.nextInt();
                System.out.println("Digite o salario: ");
                salario = leitorNumber.nextDouble();
                System.out.println("Digite o altura: ");
                altura = leitorNumber.nextDouble();
                System.out.println("Digite o peso: ");
                peso = leitorNumber.nextDouble();

                Funcionario novoFuncionario = new Funcionario(
                        identificador,nome,cursos,filhos,salario,altura,peso);
                funcionarios.adiciona(novoFuncionario);

                System.out.println("Funcionario cadastrado!");
            } else if (escolha == 2) {
                System.out.println("-".repeat(34));
                System.out.printf("%6S %-20S %6S %6S %8S %6S %6S\n",
                        "código", "nome", "cursos", "filhos", "salário", "altura", "peso");
                for (int i = 0; i < funcionarios.getTamanho(); i++) {
                    Funcionario obj = funcionarios.getElemento(i);
                    System.out.printf("%06d %-20s %6d %6d %8.2f %6.2f %6.2f\n",
                            obj.getId(),
                            obj.getNome(),
                            obj.getCursos(),
                            obj.getFilhos(),
                            obj.getSalario(),
                            obj.getAltura(),
                            obj.getPeso());
                }
                System.out.println("-".repeat(34));
            } else if (escolha == 3) {
                System.out.println("Obrigado por utilizar");
            }

        } while (escolha != 3);

    }
}