package org.example;

public class Main {
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor(100,10);

        fornecedor.vandaRecursivo(87);
        System.out.println(fornecedor.toString());
    }
}