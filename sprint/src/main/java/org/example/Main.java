package org.example;

public class Main {
    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente(0.0, "Bruno");

        conta1.depositar(100.00);
        conta1.depositar(20.);

        conta1.sacar(10.0);

        ContaCorrente conta2 = new ContaCorrente(0.0, "Paulo");

        conta1.transferir(20.00, conta2);
        conta2.getSaldo();

    }
}