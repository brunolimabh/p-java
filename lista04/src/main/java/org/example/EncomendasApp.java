package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class EncomendasApp {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        Encomendas pacote = new Encomendas();

        System.out.println("Coletando informações");
        pacote.coletarInfos();
        System.out.println("Calculando frete...");
        pacote.calcularFrete();
        System.out.println("Emitindo etiqueta...");
        pacote.emitirEtiqueta();



    }
}