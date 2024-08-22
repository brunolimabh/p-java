package org.example;

public class ListaLigadaObj<T> {
    protected NodeObj head;

    public ListaLigadaObj() {
        this.head = new NodeObj(0);
    }

    void insereNode(T valor) {
        NodeObj novo = new NodeObj(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    void exibe() {
        NodeObj atual = head.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }

    NodeObj buscaNode(T valor) {
        NodeObj atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == valor){
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }

    boolean removeNode(T valor) {
        NodeObj anterior = head;
        NodeObj atual = head.getNext();
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
        NodeObj atual = head.getNext();
        int tamanho = 0;
        while (atual != null) {
            tamanho = tamanho + 1;
            atual = atual.getNext();
        }
        return tamanho;
    }

    T getElemento(int indice) {
        NodeObj atual = head.getNext();
        for (int i = 0; atual != null; i++) {
            if (i == indice) return (T) atual.getInfo();
            atual = atual.getNext();
        }
        return null;
    }

    boolean removeOcorrencias(T valor) {
        NodeObj anterior = head;
        NodeObj atual = head.getNext();
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

    void arrayToList(T[] vetor) {
        if (getTamanho() != 0) {
            System.out.println("Operação inválida");
        } else {
            for (T obj:vetor) {
                insereNode(obj);
            }
        }
    }

    void invert() {

    }

    public NodeObj getHead() {
        return head;
    }
}
