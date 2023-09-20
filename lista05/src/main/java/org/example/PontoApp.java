package org.example;

public class PontoApp {
    public static void main(String[] args) {

        Ponto ponto = new Ponto(10,20);

        ponto.mover(15,30);

        Ponto ponto2 = new Ponto(5,10);

        ponto.getDistancia(ponto2);

    }
}
