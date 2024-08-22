package org.example;

public class ListaLigada {
    protected Node head;

    public ListaLigada() {
        this.head = new Node(0);
    }

    void insereNode(int valor) {
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    void exibe() {
        Node atual = head.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }

    Node buscaNode(int valor) {
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == valor){
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }

    boolean removeNode(int valor) {
        Node anterior = head;
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == valor){
                anterior.setNext(atual.getNext());
                return true;
            }
            anterior = atual;
            atual = atual.getNext();
        }
        return false;
    }

    int getTamanho() {
        Node atual = head.getNext();
        int tamanho = 0;
        while (atual != null) {
            tamanho = tamanho + 1;
            atual = atual.getNext();
        }
        return tamanho;
    }

    void inserirAposPrimeiroImpar(int valor) {
        Node anterior = head;
        Node atual = head.getNext();
        Node novo = new Node(valor);

        boolean inseriu = false;

        while (atual != null && !inseriu) {
            if (atual.getInfo() %2 != 0) {
                novo.setNext(atual.getNext());
                atual.setNext(novo);
                inseriu = true;
            } else {
                anterior = atual;
                atual = atual.getNext();
            }
        }

        if (!inseriu) {
            anterior.setNext(novo);
        }
    }

    Integer getElemento(int indice) {
        Node atual = head.getNext();
        for (int i = 0; atual != null; i++) {
            if (i == indice) return atual.getInfo();
            atual = atual.getNext();
        }
        return null;
    }

    boolean removeOcorrencias(int valor) {
        Node anterior = head;
        Node atual = head.getNext();
        boolean removeu = false;
        while (atual != null) {
            if (atual.getInfo() == valor){
                anterior.setNext(atual.getNext());
                removeu = true;
            }
            anterior = atual;
            atual = atual.getNext();
        }
        return removeu;
    }

    void arrayToList(int[] vetor) {
        if (getTamanho() != 0) {
            System.out.println("Operação inválida");
        } else {
            for (int numero :vetor) {
                insereNode(numero);
            }
        }
    }

    void invert() {

    }

    public Node getHead() {
        return head;
    }
}
