package org.example;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        String[] vetor = new String[10];
        Scanner leitor = new Scanner(System.in);

        // Solicitando o elemento de cada indice
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor do v[%d]:".formatted(i));
            vetor[i] = leitor.nextLine();
        }

        System.out.println("Digite um palavra aleatório");
        String palavra = leitor.nextLine();
        boolean encontrado = false;

        // Procurando a palavra no vetor
        for (int i = 0; i < vetor.length; i++) {
            if (palavra.equalsIgnoreCase(vetor[i])){
                System.out.println("Palavra '%s' encontrada no indice %d"
                        .formatted(palavra,i));
                encontrado = true;
            }
        }

        if (!encontrado){
            System.out.println("Palavra '%s' não encontrada".formatted(palavra));
        }
    }
}
