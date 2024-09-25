package org.example;

public class FilaLigadaObj<T> {
    private NodeObj<T> inicio;
    private NodeObj<T> fim;

    public FilaLigadaObj() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void insert(T valor) {
        NodeObj<T> novo = new NodeObj<>(valor);
        if (isEmpty()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setNext(novo);
            fim = novo;
        }
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T valor = inicio.getInfo();
        inicio = inicio.getNext();
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return null;
        }
        return inicio.getInfo();
    }

    public void exibe() {
        NodeObj<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }
}
