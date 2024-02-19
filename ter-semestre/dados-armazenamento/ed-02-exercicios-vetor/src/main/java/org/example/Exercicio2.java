package org.example;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        // Criando os atributor necessários
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];
        double soma = 0;

        // Solicitando o elemento de cada indice
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor do v[%d]:".formatted(i));
            vetor[i] = leitor.nextInt();
        }

        // Somando todos os elementos
        for (int num:vetor) {
            soma += num;
        }

        // Exibindo a meida do vetor
        System.out.println("A média do vetor é igual a: %.2f".formatted(soma/vetor.length));

    }
}
