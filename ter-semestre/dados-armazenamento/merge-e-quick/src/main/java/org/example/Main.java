package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] vMerge = {9,4,6,2,3,7,5,1,8};
        int[] vQuick = {8,4,6,2,3,1,9,5,7};

        System.out.println("MERGE");
        System.out.println("Antes: " + Arrays.toString(vMerge));
        mergeSort(0, vMerge.length, vMerge);
        System.out.println("Depois: " + Arrays.toString(vMerge));

        System.out.println("-".repeat(15));

        System.out.println("QUICK");
        System.out.println("Antes: " + Arrays.toString(vQuick));
        quickSort(vQuick, 0, vQuick.length - 1);
        System.out.println("Depois: " + Arrays.toString(vQuick));
    }

    public static void mergeSort(int p, int r, int[] v){
        if (p < r - 1) {
            int q = (p + r) / 2;
            mergeSort(p, q, v);
            mergeSort(q, r, v);
            intercala(p, q, r, v);
        }
    };

    public static void intercala(int p, int q, int r, int[] v){
        int[] w = new int[r - p];
        int i = p;
        int j = q;
        int k = 0;
        while (i < q && j < r) {
            if (v[i] <= v[j]) {
                w[k++] = v[i++];
            } else {
                w[k++] = v[j++];
            }
        }
        while (i < q) {
            w[k++] = v[i++];
        }
        while (j < r) {
            w[k++] = v[j++];
        }
        for (i = p; i < r; i++) {
            v[i] = w[i - p];
        }
    };

    public static void quickSort(int[] v, int indInicio, int indFim){
        if (indInicio < indFim) {
            int indicePivo = particiona(v, indInicio, indFim);
            quickSort(v, indInicio, indicePivo - 1);
            quickSort(v, indicePivo + 1, indFim);
        }
    };

    public static int particiona(int[] v, int indInicio, int indFim) {
        int pivo = v[indFim];
        int i = indFim;
        for (int j = indFim - 1; j >= indInicio; j--) {
            if (v[j] > pivo) {
                i--;
                troca(v, i, j);
            }
        }
        troca(v, indFim, i);
        return i;
    }

    public static void troca(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}