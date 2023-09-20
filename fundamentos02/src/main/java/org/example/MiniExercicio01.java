package org.example;

import java.util.Scanner;

public class MiniExercicio01 {
    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);

        Integer soma = 0;
        System.out.println("Qual a quantidade de numeros:");
        Integer qtdVetor = inputNum.nextInt();
        Integer[] numInteiros = new Integer[qtdVetor];
        for (int i = 0; i < qtdVetor;i++) {
            System.out.printf("Informe o %dº número:", i+1);
            Integer num = inputNum.nextInt();
            numInteiros[i] = num;
            soma = soma + numInteiros[i];
        }
        System.out.printf("Soma dos vetores %d", soma);
    }
}
