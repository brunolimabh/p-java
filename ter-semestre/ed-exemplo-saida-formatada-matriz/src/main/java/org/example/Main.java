package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        int[] ra = {50000,50001};
//        int ra1 = 5000;
//        int ra2 = 50001;
//        String[] nome = {"Maria", "Jose"};
//        String nome1 = "Maria";
//        String nome2 = "Jose";
//        Double[] nota = {9.5,8.0};
//        Double nota1 = 9.5;
//        Double nota2 = 8.0;
//
//        System.out.println("-".repeat(34));
//        System.out.printf("|%7S | %-14S | %7S |\n", "ra", "nome", "nota");
//        for (int i = 0; i < ra.length; i++) {
//            System.out.printf("|%7d | %-14s | %7.2f |\n", ra[i], nome[i] , nota[i]);
//        }
//        System.out.println("-".repeat(34));
//
//    }

    public static void main(String[] args) {
        int[] vetor = new int[7];
        int[][] matriz = new int[3][4];

        Scanner leitor = new Scanner(System.in);

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.printf("Digite o valor de matriz[%d][%d]: \n", linha, coluna);
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

    }
}