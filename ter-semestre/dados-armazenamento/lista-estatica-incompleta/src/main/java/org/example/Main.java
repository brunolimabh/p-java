package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);
        System.out.println(lista.exibe());
        lista.removePeloIndice(4);
        System.out.println(lista.exibe());
        lista.removeElemento(10);
        System.out.println(lista.exibe());
        lista.substitui(30,50);
        System.out.println(lista.exibe());
        System.out.println(lista.contaOcorrencias(10));
        lista.adicionaNoInicio(60);
        System.out.println(lista.exibe());
    }
}