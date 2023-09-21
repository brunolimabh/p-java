package org.example;

public class Main {
    public static void main(String[] args) {
        Livro big = new Livro("1","bigbig","Bruno",10);

        Double peso = big.calcularPeso();
        System.out.println(peso);
    }
}