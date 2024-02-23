package org.example;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];
        int[] acima;
        double soma = 0;
        double media = 0;
        int qtdAcima = 0;

        // Solicitando o elemento de cada indice
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor do v[%d]:".formatted(i));
            vetor[i] = leitor.nextInt();
        }

        // Somando todos os elementos
        for (int num:vetor) {
            soma += num;
        }
        media = soma/vetor.length;

        for (int num:vetor) {
            if (num > media){
                qtdAcima++;
            }
        }

        acima = new int[qtdAcima];
        int indiceDaVez = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > media){
                acima[indiceDaVez] = vetor[i];
                indiceDaVez++;
            }
        }

        System.out.println("A média do vetor é igual a: %.2f".formatted(media));
        System.out.println("Números acima da média:");
        for (int num:acima) {
            System.out.println(num);
        }
    }
}
