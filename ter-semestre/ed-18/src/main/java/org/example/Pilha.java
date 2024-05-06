package org.example;

public class Pilha {

    // 01) Atributos
    private int[] pilha;
    private int topo;

    // 02) Construtor
    public Pilha(int capacidade) {
        pilha = new int[capacidade];
        topo = -1;
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
    public void push(int info) {
        if (isFull()) throw new IllegalStateException();
        pilha[++topo] = info;
    }

    // 06) MÃ©todo pop
    public int pop() {
        return pilha[topo--];
    }

    // 07) MÃ©todo peek
    public int peek() {
        if (isEmpty()) return -1;
        return pilha[topo];
    }

    // 08) MÃ©todo exibe
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = pilha.length-1; i >= 0; i--) {
                int info = pilha[i];
                System.out.println("| %4d |".formatted(pilha[i]));
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