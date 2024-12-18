package org.example;

public class HeapSort {
    public void heapSortAsc(int[] v) {
        int n = v.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustaHeap(n, v, i);
        }

        for (int m = n - 1; m >= 0; m--) {
            troca(v, 0, m);
            ajustaHeap(m, v, 0);
            exibeVetor(v);
        }
    }

    public void heapSortDesc(int[] v) {
        int n = v.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustaHeapDec(n, v, i);
        }

        for (int m = n - 1; m >= 0; m--) {
            troca(v, 0, m);
            ajustaHeapDec(m, v, 0);
            exibeVetor(v);
        }
    }

    private void ajustaHeap(int n, int[] v, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && v[esq] > v[maior]) {
            maior = esq;
        }

        if (dir < n && v[dir] > v[maior]) {
            maior = dir;
        }

        if (maior != i) {
            troca(v, i, maior);
            ajustaHeap(n, v, maior);
        }
    }

    private void ajustaHeapDec(int n, int[] v, int i) {
        int menor = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && v[esq] < v[menor]) {
            menor = esq;
        }

        if (dir < n && v[dir] < v[menor]) {
            menor = dir;
        }

        if (menor != i) {
            troca(v, i, menor);
            ajustaHeapDec(n, v, menor);
        }
    }

    private void troca(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private void exibeVetor(int[] v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
