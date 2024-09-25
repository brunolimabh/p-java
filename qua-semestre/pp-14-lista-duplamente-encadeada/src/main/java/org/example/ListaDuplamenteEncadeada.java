package org.example;

public class ListaDuplamenteEncadeada {
    private Node head;
    private Node tail;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        head = new Node(-1);
        tail = new Node(-1);
        head.setNext(tail);
        tail.setPrev(head);
        tamanho = 0;
    }

    public void insereNodeInicio(int valor) {
        Node novo = new Node(valor);
        Node primeiro = head.getNext();

        novo.setNext(primeiro);
        novo.setPrev(head);
        head.setNext(novo);
        if (primeiro != null) {
            primeiro.setPrev(novo);
        }
        tamanho++;
    }

    public void insereNodeFinal(int valor) {
        Node novo = new Node(valor);
        Node ultimo = tail.getPrev();

        novo.setNext(tail);
        novo.setPrev(ultimo);
        tail.setPrev(novo);
        if (ultimo != null) {
            ultimo.setNext(novo);
        }
        tamanho++;
    }

    public void exibeDoInicio() {
        Node atual = head.getNext();
        while (atual != tail) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getNext();
        }
        System.out.println();
    }

    public void exibeDoFinal() {
        Node atual = tail.getPrev();
        while (atual != head) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getPrev();
        }
        System.out.println();
    }

    public boolean removeNode(int valor) {
        Node atual = head.getNext();
        while (atual != tail) {
            if (atual.getInfo() == valor) {
                atual.getPrev().setNext(atual.getNext());
                atual.getNext().setPrev(atual.getPrev());
                tamanho--;
                return true;
            }
            atual = atual.getNext();
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int removeNodeInicio() {
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        Node primeiro = head.getNext();
        int valor = primeiro.getInfo();
        head.setNext(primeiro.getNext());
        primeiro.getNext().setPrev(head);
        tamanho--;
        return valor;
    }

    public int removeNodeFinal() {
        if (tamanho == 0) {
            throw new IllegalStateException("Lista vazia");
        }
        Node ultimo = tail.getPrev();
        int valor = ultimo.getInfo();
        tail.setPrev(ultimo.getPrev());
        ultimo.getPrev().setNext(tail);
        tamanho--;
        return valor;
    }
}
