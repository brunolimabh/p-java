package org.example;

public class Main {
    public static void main(String[] args) {

        Empresa sptech = new Empresa();

        Vendedor v1 = new Vendedor("12","Bruno",1350.0,10.0);
        Horista h1 = new Horista("13", "Paulo", 8,15.00);
        Horista h2 = new Horista("14", "Caio", 6,25.00);


        sptech.adicionarFunc(v1);
        sptech.adicionarFunc(h1);
        sptech.adicionarFunc(h2);

        sptech.exibeTodos();

        sptech.exibeTotalSalario();

    }
}