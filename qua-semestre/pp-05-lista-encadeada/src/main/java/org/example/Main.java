package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("_".repeat(30));
        System.out.println("Lista Ligada Ordenada");
        ListaLigadaOrdenada listaOrdenada = new ListaLigadaOrdenada();
        listaOrdenada.insereNode(10);
        listaOrdenada.insereNode(4);
        listaOrdenada.insereNode(6);
        listaOrdenada.insereNode(15);
        listaOrdenada.insereNode(9);
        System.out.println("Exibindo lista: ");
        listaOrdenada.exibe();
        System.out.println("Buscando por 4: " + listaOrdenada.buscaNode(4));
        System.out.println("Remover 9: " + listaOrdenada.removeNode(9));
        System.out.println("Exibindo lista: ");
        listaOrdenada.exibe();

        System.out.println("_".repeat(30));
        System.out.println("Lista Ligada");
        ListaLigada lista = new ListaLigada();
//        lista.insereNode(10);
//        lista.insereNode(9);
//        lista.insereNode(6);
//        lista.insereNode(15);
//        lista.insereNode(4);
//        lista.insereNode(6);
        System.out.println("Exibindo lista: ");
        lista.exibe();
//        lista.inserirAposPrimeiroImpar(5);
        System.out.println("Exibindo lista: ");
        lista.exibe();
        System.out.println("Buscando por indice 3: " + lista.getElemento(3));
        System.out.println("Remover ocorrencias 6: " + lista.removeOcorrencias(6));
        System.out.println("Exibindo lista: ");
        lista.exibe();

        int[] list = {30, 50, 6, 90, 110};
        lista.arrayToList(list);
        System.out.println("Exibindo lista: ");
        lista.exibe();
        lista.invert();
        System.out.println("Exibindo lista: ");
        lista.exibe();
    }
}