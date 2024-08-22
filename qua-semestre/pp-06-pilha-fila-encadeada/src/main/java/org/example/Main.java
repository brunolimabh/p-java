package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("_".repeat(30));
        System.out.println("Lista Ligada");
        ListaLigada lista = new ListaLigada();
        lista.insereNode(1);
        lista.insereNode(2);
        lista.insereNode(3);
        lista.insereNode(2);
        lista.insereNode(5);
        lista.removeNode(2);
        System.out.println("Exibindo lista: ");
        lista.exibe();
        System.out.println("Tamanho lista: ");
        System.out.println(lista.getTamanhoRecursivo());

//        lista.inserirAposPrimeiroImpar(5);
//        System.out.println("Exibindo lista: ");
//        lista.exibe();
//        System.out.println("Buscando por indice 3: " + lista.getElemento(3));
//        System.out.println("Remover ocorrencias 6: " + lista.removeOcorrencias(6));
//        System.out.println("Exibindo lista: ");
//        lista.exibe();

//        int[] list = {30, 50, 6, 90, 110};
//        lista.arrayToList(list);
//        System.out.println("Exibindo lista: ");
//        lista.exibe();
//        lista.invert();
//        System.out.println("Exibindo lista: ");
//        lista.exibe();
    }
}