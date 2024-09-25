package org.example;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.insereNodeInicio(10);
        lista.insereNodeInicio(20);
        lista.insereNodeInicio(30);
        System.out.println("Exibindo lista do inicio: ");
        lista.exibeDoInicio();

        lista.insereNodeFinal(40);
        lista.insereNodeFinal(50);
        System.out.println("Exibindo lista do final: ");
        lista.exibeDoFinal();

        int removidoInicio = lista.removeNodeInicio();
        System.out.println("Valor removido do inicio: " + removidoInicio);
        System.out.println("Exibindo lista do inicio: ");
        lista.exibeDoInicio();

        int removidoFinal = lista.removeNodeFinal();
        System.out.println("Valor removido do final: " + removidoFinal);
        System.out.println("Exibindo lista do final: ");
        lista.exibeDoFinal();

        boolean removido = lista.removeNode(10);
        System.out.println("Removendo valor 10: " + removido);
        System.out.println("Exibindo lista do inicio: ");
        lista.exibeDoInicio();

        System.out.println("Tamanho da lista" + lista.getTamanho());

        ListaDuplamenteEncadeada listaBinaria = new ListaDuplamenteEncadeada();
        System.out.println("Converter decimal 12 para binário: ");
        converterDecimalBinario(listaBinaria, 12);
        listaBinaria.exibeDoFinal();
    }

    public static void converterDecimalBinario(ListaDuplamenteEncadeada lista, int numero) {
        while (numero > 0) {
            int resto = numero % 2;
            lista.insereNodeFinal(resto);
            numero = numero / 2;
        }
    }
}
