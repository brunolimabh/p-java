package org.example;

public class PilhaLigada {
    private Node topo;

    public PilhaLigada() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(int valor) {
        Node novo = new Node(valor);
        novo.setNext(topo);
        topo = novo;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        int valor = topo.getInfo();
        topo = topo.getNext();
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia.");
        }
        return topo.getInfo();
    }

    public void exibe() {
        Node atual = topo;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }
}

