package org.example;

public class ProgressaoAritmeticaApp {

    public static void main(String[] args) {

        ProgressaoAritmetica lista  = new ProgressaoAritmetica(3, 3);

        lista.calcularTermo(10);

         System.out.println(lista.getListaTermo());

    }

}
