package org.example;

import java.util.Scanner;

public class Termometro {
    Scanner inputNumber = new Scanner(System.in);
    Double temperaturaAtual = 0.0;
    Double temperaturaMax = 0.0;
    Double temperaturaMin = 0.0;

    void aumentaTemperatura(){
        System.out.println("Informe a nova temperatua atual:");
        Double novaTemp = inputNumber.nextDouble();
        temperaturaAtual = novaTemp;
        if (novaTemp > temperaturaMax) {
            temperaturaMax = novaTemp;
            System.out.println("Tempoeratura máxima atualizada para %.1f".formatted(temperaturaMax));
        }
    }
    void diminuiTemperatura(){
        System.out.println("Informe a nova temperatua atual:");
        Double novaTemp = inputNumber.nextDouble();
        temperaturaAtual = novaTemp;
        if (novaTemp < temperaturaMin) {
            temperaturaMin = novaTemp;
            System.out.println("Tempoeratura mínima atualizada para %.1f".formatted(temperaturaMin));
        }
    }
    void exibeFahreinheit(){
        Double fahre = (temperaturaAtual * 9/5) + 32;
        System.out.println("A temperatura atual de %.1f Celsius é igual a %.1f em Fahreinheit"
                .formatted(temperaturaAtual, fahre));
    }

}