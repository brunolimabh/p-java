package org.example;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        Scanner leitor = new Scanner(System.in);
        int[] vetor = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dia;
        int mes;
        int diaAno = 0;

        do {
            System.out.println("Digite um dia:");
            dia = leitor.nextInt();
        } while (dia < 1 || dia > 31);

        do {
            System.out.println("Digite um mês:");
            mes = leitor.nextInt();
        } while (mes < 1 || mes > 12);


        // Calculando qtd de dias
        for (int i = 0; i < mes-1; i++) {
            diaAno += vetor[i];
        }
        diaAno += dia;

        System.out.println("O dia %d/%d corresponde ao dia %d do ano"
                .formatted(dia,mes,diaAno));
    }
}
