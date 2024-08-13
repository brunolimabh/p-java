package org.example;

public class Main {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.insereNode(10);
        lista.insereNode(3);
        lista.insereNode(14);
        lista.insereNode(8);
        lista.insereNode(6);
        System.out.println("Exibindo lista: ");
        lista.exibe();
        System.out.println("Exibindo tamanho: " + lista.getTamanho());
        System.out.println("Buscando por 8: " + lista.buscaNode(8));
        System.out.println("Removendo 8: " + lista.removeNode(8));
        System.out.println("Buscando por 8: " + lista.buscaNode(8));
        System.out.println("Exibindo tamanho: " + lista.getTamanho());
    }
}