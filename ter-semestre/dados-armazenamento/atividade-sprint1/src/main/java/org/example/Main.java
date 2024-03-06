package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Bruno Henrique", "Maisa Oliveira", 6, 0,10.430,1.82,72.4);
        Funcionario f2 = new Funcionario("Pedro Lima", "Patricia Almeida", 6, 1,4.290,1.80,59.2);
        Funcionario f3 = new Funcionario("Henrique Oliveira", "Julia Prestes", 6, 3,6.180,1.69,64.6);
        Funcionario f4 = new Funcionario("Marcos Antonio", "Maria Oliveira", 6, 2,2.540,1.71,39.5);
        Funcionario f5 = new Funcionario("Marcelo Gonçalves", "Larissa Silva", 6, 2,5.910,1.78,44.4);
        Funcionario f6 = new Funcionario("Leonardo Silva", "Celia Almeida", 6, 4,1.360,1.75,57.2);
        Funcionario f7 = new Funcionario("Rafael Pereira", "Dora Cruz", 6, 1,3.990,1.65,64.1);
        Funcionario f8 = new Funcionario("Luiz Gabriel", "Alessandra Faria", 6, 0,4.230,1.72,66.6);

        Funcionario[] funcionarios = {f1,f2,f3,f4,f5,f6,f7,f8};
        Ordenacao ordenacao = new Ordenacao();

        System.out.println("Lista de funcionários:");
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println(funcionarios[i]);
        }

        System.out.println("-".repeat(15));

        System.out.println("Ordenando por peso:");
        Funcionario[] funcPorPeso = ordenacao.ordenarPorPeso(funcionarios);
        for (int i = 0; i < funcPorPeso.length; i++) {
            System.out.println(funcPorPeso[i]);
        }

        System.out.println("-".repeat(15));

        System.out.println("Ordenando por nome:");
        Funcionario[] funcPorNome = ordenacao.ordenarPorNome(funcionarios);
        for (int i = 0; i < funcPorNome.length; i++) {
            System.out.println(funcPorNome[i]);
        }

        System.out.println("-".repeat(15));

        System.out.println("Buscar por 'Bruno Henrique' em pesquisa binária::");
        int indice = ordenacao.pesquisaBinaria(funcionarios,"Bruno Henrique");
        if (indice == -1){
            System.out.println("Funcionário não existe");
        } else {
            System.out.println("Indice do funcionário: %d".formatted(indice));
        }

    }
}