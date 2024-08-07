package org.example;

public class FilaPilha {
    private int[] vetor;
    private int tam;
    private int topo;

    public FilaPilha(int capacidade) {
        this.vetor = new int[capacidade];
        this.tam = 0;
        this.topo = capacidade;
    }

    public boolean isEmptyFila() {
        return false;
    }

    public boolean isEmptyPilha() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void insert(int info) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            vetor[tam] = info;
            tam++;
        }
    }

    public void push(int info) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            vetor[--topo] = info;
        }
    }

    public int peekFila() {
        return vetor[0];
    }

    public int peekPilha() {
        return vetor[topo];
    }

    public int poll() {
        if (isEmptyFila()) {
            System.out.println("Vetor vazio");
            return 0;
        } else {
            int info = peekFila();
            for (int i = 0; i < tam - 1; i++) {
                if (i == tam - 2) {
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = 0;
                } else {
                    vetor[i] = vetor[i+1];
                }
            }
            tam--;
            return info;
        }
    }

    public int pop(int pilha) {
        return vetor[topo++];
    }

    public void exibe() {
        for (int i = 0; i <= vetor.length - 1; i++) {
            int info = vetor[i];
            System.out.printf(info + " ");
        }
    }
}
