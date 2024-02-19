package org.example;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];

        // Solicitando o elemento de cada indice
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor do v[%d]:".formatted(i));
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Digite um número p/ verificar no vetor:");
        int num = leitor.nextInt();
        int contador = 0;

        // Procurando o numero no vetor
        for (int i = 0; i < vetor.length; i++) {
            if (num == vetor[i]){
                contador++;
            }
        }

        System.out.println("O número '%d' foi encontado %d vezes"
                .formatted(num,contador));
    }
}
