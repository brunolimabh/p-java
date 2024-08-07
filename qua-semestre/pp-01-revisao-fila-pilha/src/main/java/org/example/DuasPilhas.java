package org.example;

public class DuasPilhas {
    private int[] vetor;
    private int topo1;
    private int topo2;

    public DuasPilhas(int capacidade) {
        this.vetor = new int[capacidade];
        this.topo1 = -1;
        this.topo2 = capacidade;
    }

    public boolean isEmpty(int pilha) {
        if (pilha == 1) {
            return topo1 == -1;
        } else {
            return topo2 == vetor.length;
        }
    }

    public boolean isFull() {
        return topo1 == topo2 - 1;
    }

    public void push(int pilha, int info) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            if (pilha == 1) vetor[++topo1] = info;
            if (pilha == 2) vetor[--topo2] = info;
        }
    }

    public int peek(int pilha) {
        if (pilha == 1) return vetor[topo1];
        return vetor[topo2];
    }

    public int pop(int pilha) {
        if (pilha == 1) return vetor[topo1--];
        return vetor[topo2++];
    }

    public void exibe() {
        for (int i = vetor.length-1; i >= 0; i--) {
            int info = vetor[i];
            System.out.printf(info + " ");
        }
    }

}
