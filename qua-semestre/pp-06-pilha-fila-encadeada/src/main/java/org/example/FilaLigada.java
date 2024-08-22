package org.example;

public class FilaLigada {
    private Node inicio;
    private Node fim;

    public FilaLigada() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void insert(int valor) {
        Node novo = new Node(valor);
        if (isEmpty()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setNext(novo);
            fim = novo;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia.");
        }
        int valor = inicio.getInfo();
        inicio = inicio.getNext();
        if (inicio == null) {
            fim = null; // Se a fila ficou vazia, atualize o fim para null
        }
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A fila está vazia.");
        }
        return inicio.getInfo();
    }

    public void exibe() {
        Node atual = inicio;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }
}

