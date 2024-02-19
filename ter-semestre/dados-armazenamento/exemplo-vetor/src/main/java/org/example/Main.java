package org.example;

import java.util.Scanner;

public class Main {

    public static void exibeVetor(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.println("vetor[%d]= %d".formatted(i,v[i]));
        }
    }

    public static  void scanVetor(int[] v, Scanner scan){
        for (int i = 0; i < v.length; i++) {
            System.out.println("Digite o valor do vetor[%d]:".formatted(i));
            v[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        // Criacao do leitor
        Scanner number = new Scanner(System.in);
        Scanner texto = new Scanner(System.in);

        // Criacao de um vetor
        int[] vetor = new int[5];
        int[] vetor2 = {100,200,300,400,500,600,700};
        String[] vetor3 = new String[4];

        int[] vetor4;
        int tamanho;

        // Preencher o vetor 1 com valores
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i * 10;
        }
        System.out.println("\nVetor1:");
        exibeVetor(vetor);

        // Preencher o vetor 1 com valores do usuario
        scanVetor(vetor,number);
        System.out.println("\nVetor1:");
        exibeVetor(vetor);

        System.out.println("\nVetor2:");
        exibeVetor(vetor2);

        // Preencher o vetor 3 com valores do usuario
        for (int i = 0; i < vetor3.length; i++) {
            System.out.println("Digite o valor do vetor[%d]:".formatted(i));
            vetor3[i] = texto.nextLine();
        }

        System.out.println("\nVetor3:");
        for (String s: vetor3) {
            System.out.println(s);
        }

        // Digite o tamanho do v4
        do {
            System.out.println("Digite um valor > 2 p/ o vetor4:");
            tamanho = number.nextInt();
        } while (tamanho <= 2);
        vetor4 = new int[tamanho];

        // Preenche vetor4
        scanVetor(vetor4,number);
        // Exibe vetor4
        exibeVetor(vetor4);

        System.out.println("\nDesafio 1");
        // Desafio1: Exibir a soma dos valores do 1° vetor
        int soma = 0;
        for (int num:vetor) {
            soma += num;
        }
        System.out.println("Soma do vetor1: %d".formatted(soma));

        System.out.println("\nDesafio 2");
        // Desafio2: Exibir a quantidade de valores pares do 1° vetor
        int qtd = 0;
        for (int num:vetor) {
            if (num %2 == 0){
                qtd++;
            }
        }
        System.out.println("Quantidade de valores pares do vetor1: %d".formatted(qtd));

        System.out.println("\nDesafio 3");
        // Desafio3: Criar um vetor de Strings já inicializado com os nomes dos dias da semana,
        // Solicitar um inteiro de 1 a 8
        // Ficar em loop até que o valor seja valido
        // Exibir o dia da semana correspondente
        String[] semana = {"Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"};
        int diaEscolhido;
        do {
            System.out.println("Digite um numero de 1 a 7:");
            diaEscolhido = number.nextInt();
        } while (diaEscolhido < 1 || diaEscolhido > 7);
        System.out.println("O dia escolhido foi: %s".formatted(semana[diaEscolhido-1]));
    }
}