package org.example;

public class PilhaObj <T> {

    // 01) Atributos
    private T[] pilha;
    private int topo;

    // 02) Construtor
    public PilhaObj(int capacidade) {
        this.pilha = (T[]) new Object[capacidade];
        this.topo = -1;
    }

    // 03) MÃ©todo isEmpty
    public Boolean isEmpty() {
        return topo == -1;
    }

    // 04) MÃ©todo isFull
    public Boolean isFull() {
        return pilha.length - 1== topo;
    }

    // 05) MÃ©todo push
    public void push(T info) {
        if (isFull()) throw new IllegalStateException();
        pilha[++topo] = info;
    }

    // 06) MÃ©todo pop
    public T pop() {
        return pilha[topo--];
    }

    // 07) MÃ©todo peek
    public T peek() {
        if (isEmpty()) return null;
        return pilha[topo];
    }

    // 08) MÃ©todo exibe
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


    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }


}
