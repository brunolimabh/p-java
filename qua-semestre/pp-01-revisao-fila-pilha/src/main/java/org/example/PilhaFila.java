package org.example;

public class PilhaFila {

    private int[] vetor;
    private int topo;
    private int tam;

    public PilhaFila(int capacidade) {
        this.vetor = new int[capacidade];
        this.topo = -1;
        this.tam = capacidade - 1;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmptyFila() {
        return false;
    }

    public boolean isEmptyPilha() {
        return false;
    }

    public void push(int info) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            vetor[++topo] = info;
        }
    }

    public int peek() {
        return vetor[topo];
    }

    public int pop() {
        return vetor[topo--];
    }

    public void insert(int info) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            vetor[tam] = info;
            tam--;
        }
    }

    public void exibe() {
        for (int i = 0; i <= vetor.length - 1; i++) {
            int info = vetor[i];
            System.out.printf(info + " ");
        }
    }
}
