package org.example;

public class PilhaLigadaObj<T> {
    private NodeObj<T> topo;

    public PilhaLigadaObj() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(T valor) {
        NodeObj<T> novo = new NodeObj<>(valor);
        novo.setNext(topo);
        topo = novo;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
        }
        T valor = topo.getInfo();
        topo = topo.getNext();
        return valor;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return topo.getInfo();
    }

    public void exibe() {
        NodeObj<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }
}


