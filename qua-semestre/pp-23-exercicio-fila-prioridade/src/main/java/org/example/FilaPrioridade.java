package org.example;

import java.util.Arrays;

public class FilaPrioridade {
    private Musica[] heap;
    private int tamanho;

    public FilaPrioridade(int tamanho) {
        this.heap = new Musica[tamanho];
        this.tamanho = 0;
    }

    public boolean isFull() {
        return tamanho == heap.length;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void inserir(Musica novaMusica) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia.");
        }
        heap[tamanho] = novaMusica;
        tamanho++;
        subirHeap(tamanho - 1);
    }

    private void subirHeap(int i) {
        int pai = (i - 1) / 2;
        while (i > 0 && heap[i].getPrioridade() > heap[pai].getPrioridade()) {
            swap(i, pai);
            i = pai;
            pai = (i - 1) / 2;
        }
    }

    public Musica remover() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        Musica raiz = heap[0];
        heap[0] = heap[tamanho - 1];
        tamanho--;
        descerHeap(0); // Ajusta o heap após a remoção
        return raiz;
    }

    private void swap(int i, int j) {
        Musica temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void descerHeap(int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tamanho && heap[esquerda].getPrioridade() > heap[maior].getPrioridade()) {
            maior = esquerda;
        }
        if (direita < tamanho && heap[direita].getPrioridade() > heap[maior].getPrioridade()) {
            maior = direita;
        }
        if (maior != i) {
            swap(i, maior);
            descerHeap(maior);
        }
    }

    public void exibirHeap() {
        System.out.println(Arrays.toString(heap));
    }

}
