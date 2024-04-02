package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.add(50);
        System.out.println(lista.list());
        lista.removeIndice(4);
        System.out.println(lista.list());
        lista.removeElement(10);
        System.out.println(lista.list());

    }
}