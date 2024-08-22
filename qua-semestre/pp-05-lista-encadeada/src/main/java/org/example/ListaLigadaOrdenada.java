package org.example;

public class ListaLigadaOrdenada extends ListaLigada {
    public ListaLigadaOrdenada() {
        super();
    }

    @Override
    void insereNode(int valor) {
        Node anterior = head;
        Node atual = head.getNext();
        Node novo = new Node(valor);

        boolean inseriu = false;

        while (atual != null && !inseriu) {
            if (atual.getInfo() > valor) {
                anterior.setNext(novo);
                novo.setNext(atual);
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

    @Override
    Node buscaNode(int valor) {
        Node atual = head.getNext();
        while (atual.getInfo() <= valor) {
            if (atual.getInfo() == valor){
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }

    @Override
    boolean removeNode(int valor) {
        Node anterior = head;
        Node atual = head.getNext();
        while (atual.getInfo() <= valor) {
            if (atual.getInfo() == valor){
                anterior.setNext(atual.getNext());
                return true;
            }
            anterior = atual;
            atual = atual.getNext();
        }
        return false;    }
}
