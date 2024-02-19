package org.example;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        // Criando os atributos necessários
        Scanner text = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        String[] vCarro = new String[5];
        int[] vKm = new int[5];
        int economico = -1;

        // Solicitando os carros
        for (int i = 0; i < vCarro.length; i++) {
            System.out.println("Digite o carro do v[%d]:".formatted(i));
            vCarro[i] = text.nextLine();
        }

        // Solicitando os KMs
        for (int i = 0; i < vKm.length; i++) {
            System.out.println("Digite o km do carro %s:".formatted(vCarro[i]));
            vKm[i] = number.nextInt();
        }

        // Verificando carro mais econômico
        for (int i = 0; i < vKm.length; i++) {
            if (vKm[i] > economico){
                economico = i;
            }
        }
        System.out.println("O carro mais econômico é o %s percorrendo %d KM/L"
                .formatted(vCarro[economico],vKm[economico]));
    }
}
