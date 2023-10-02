package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ContaCorrente conta = new ContaCorrente("bruno", 0.0);
        conta.depositar(10.0);
        conta.sacar(5.0);
        conta.exibirExtrato();
        System.out.println(conta);
    }


}