package org.example;

public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        this.pilha = (T[]) new Object[capacidade];
        this.topo = -1;
    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return pilha.length - 1== topo;
    }

    public void push(T info) {
        if (isFull()) throw new IllegalStateException();
        pilha[++topo] = info;
    }

    public T pop() {
        return pilha[topo--];
    }

    public T peek() {
        if (isEmpty()) return null;
        return pilha[topo];    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = pilha.length-1; i >= 0; i--) {
                T info = pilha[i];
                System.out.println("| %4s |".formatted(pilha[i]));
                if (i == 0) {
                    System.out.println("|______|");
                }
            }
        }
    }

    public int getTopo() {
        return topo;
    }
}