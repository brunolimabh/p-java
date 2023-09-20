package org.example;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        Double priNum = input.nextDouble();
        System.out.println("Digite o segundo número: ");
        Double segNum = input.nextDouble();
        System.out.println("Digite a operação + - * / : ");
        char operador = input.next().charAt(0);


    }

}