package org.example;


import java.util.Arrays;

public class Ordenacao {

    public void selectionSort(int[] v) {
        int comparacao = 0;
        int troca = 0;
        for (int i = 0; i < v.length -1; i++) {
            for (int j = i+1; j < v.length; j++) {
                comparacao++;
                if (v[j] < v[i]){
                    troca++;
                    int aux = v[j];
                    v[j] = v[i];
                    v[i] = aux;
                }
            }
        }
        System.out.println("""
                Array: %s
                Comparação: %d
                Trocas: %d
                """.formatted(Arrays.toString(v),comparacao,troca));
        ;
    }

    public void selectionSortOtimizado(int[] v) {
        int comparacao = 0;
        int troca = 0;
        for (int i = 0; i < v.length -1; i++) {
            int indiceMenor = i;
            for (int j = i+1; j < v.length; j++) {
                comparacao++;
                if (v[j] < v[indiceMenor]){
                    indiceMenor = j;
                }
            }
            if (v[indiceMenor] != v[i]){
                troca++;
                int aux = v[i];
                v[i] = v[indiceMenor];
                v[indiceMenor] = aux;
            }
        }
        System.out.println("""
                Array: %s
                Comparação: %d
                Trocas: %d
                """.formatted(Arrays.toString(v),comparacao,troca));
        ;
    }
    public void bubbleSort(int[] v){
        int comparacao = 0;
        int troca = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length -1; j++) {
                comparacao++;
                if (v[j+1] < v[j]){
                    troca++;
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        System.out.println("""
                Array: %s
                Comparação: %d
                Trocas: %d
                """.formatted(Arrays.toString(v),comparacao,troca));
        ;
    }
    public void insertionSort(int[] v){
        int comparacao = 0;
        int troca = 0;
        for (int i = 1; i < v.length; i++) {
            int aux = v[i];
            int j = i-1;
            comparacao++;
            while (j > -1 && v [j] > aux) {
                comparacao++;
                troca++;
                v [j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
        }
        System.out.println("""
                Array: %s
                Comparação: %d
                Trocas: %d
                """.formatted(Arrays.toString(v),comparacao,troca));
        ;
    }
    public int pesquisaBinaria(int[] v, int x){
        int indiceInicio = 0;
        int indiceFim = v.length-1;

        while (indiceInicio <= indiceFim){
            int indiceMeio = (indiceInicio + indiceFim) / 2;
            if (x == v[indiceMeio]){
                return indiceMeio;
            } else if (x > v[indiceMeio]){
                indiceInicio = indiceMeio+1;
            } else {
                indiceFim = indiceMeio-1;
            }
        }
        return -1;
    }
}
