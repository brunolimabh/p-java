package org.example;

public class Main {
    public static void main(String[] args) {

        int[] v1 = {1,5,4,6,3};
        int[] v2 = {4,7,5,2,8,1,6,3};
        int[] vOrdenada = {10,20,30,40,50,60,70,80};

        Ordenacao ordenacao = new Ordenacao();
//        ordenacao.selectionSort(v2);
//        ordenacao.selectionSortOtimizado(v2);
//        ordenacao.bubbleSort(v2);
        ordenacao.insertionSort(v2);
//        System.out.println(ordenacao.pesquisaBinaria(vOrdenada,0));
    }
}