package org.example;

public class Main {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] vetorCrescente = {16, 13, 5, 6, 12, 9, 7, 4, 11, 8, 10, 14, 15};
        int[] vetorDecrescente = {16, 13, 5, 6, 12, 9, 7, 4, 11, 8, 10, 14, 15};

        System.out.println("Ordem Crescente:");
        heapSort.heapSortAsc(vetorCrescente);

        System.out.println("Ordem Decrescente:");
        heapSort.heapSortDesc(vetorDecrescente);
    }
}