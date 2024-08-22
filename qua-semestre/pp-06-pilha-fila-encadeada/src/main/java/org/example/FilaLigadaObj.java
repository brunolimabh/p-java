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
            throw new RuntimeException("A fila está vazia.");
        }
        T valor = inicio.getInfo();
        inicio = inicio.getNext();
        if (inicio == null) {
            fim = null; // Se a fila ficou vazia, atualize o fim para null
        }
        return valor;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia.");
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
