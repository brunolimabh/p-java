package org.example;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[7];

        // Solicitando o elemento de cada indice
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor do v[%d]:".formatted(i));
            vetor[i] = leitor.nextInt();
        }

        System.out.println("-".repeat(30));

        System.out.println("Percorrendo vetor de frente p/ tras:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[%d]: %d".formatted(i, vetor[i]));
        }

        System.out.println("-".repeat(30));

        System.out.println("Percorrendo vetor de tras p/ frente:");
        for (int i = vetor.length - 1; i > 0; i--) {
            System.out.println("vetor[%d]: %d".formatted(i, vetor[i]));
        }

    }
}
