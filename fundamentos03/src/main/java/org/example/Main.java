package org.example;

public class Main {
    public static void main(String[] args) {

        /*
        Carro carrito1 = new Carro();
        carrito1.marca = "Fiat";
        carrito1.modelo = "Uno";
        carrito1.anoLancamento = 1995;

        Carro carrito2 = new Carro();
        carrito2.marca = "Wolksvraulins";
        carrito2.modelo = "Golete";
        carrito2.anoLancamento = 2000;

        System.out.println("Carrito 1:" + carrito1.modelo);
        System.out.println("Carrito 2:" + carrito2.modelo);

        System.out.println("-".repeat(30));

        System.out.println("Torreto acelerando...");
        carrito1.acelerar();
        carrito1.frear();

        System.out.println("É o BRAIA...");
        carrito2.acelerar();
        carrito2.frear();
         */

        Calculadora calculadora1 = new Calculadora();
        Calculadora calculadora2 = new Calculadora();
        Integer resultSoma = calculadora1.somar(10,10);

        System.out.println("Soma" + resultSoma);
        System.out.println("nrm" + calculadora2.numeroOperacoes);
        System.out.println("Fim");

    }
}