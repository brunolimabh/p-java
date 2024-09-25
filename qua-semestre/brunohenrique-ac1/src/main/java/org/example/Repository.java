package org.example;

public class Repository {
    private Node head;

    public Repository() {
        this.head = new Node('0');
    }

    public void addAtEnd(char value) {
        Node novo = new Node(value);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    public void addAfterSpace(char value) {
        Node anterior = head;
        Node atual = head.getNext();
        Node novo = new Node(value);

        boolean inseriu = false;

        while (atual != null && !inseriu) {
            if (atual.getInfo() == ' ') {
                novo.setNext(atual.getNext());
                atual.setNext(novo);
                inseriu = true;
            } else {
                anterior = atual;
                atual = atual.getNext();
            }
        }

    }

    public void addAtIndex(int index, char value) {
        Node anterior = head;
        Node atual = head.getNext();
        Node novo = new Node(value);

        boolean inseriu = false;
        int indice = 0;
        while (atual != null && !inseriu) {
            if (indice == index) {
                novo.setNext(atual.getNext());
                atual.setNext(novo);
                inseriu = true;
            } else {
                anterior = atual;
                atual = atual.getNext();
                indice++;
            }
        }
    }

    public void duplicateValue(char value) {
        Node anterior = head;
        Node atual = head.getNext();

        boolean inseriu = false;
        int cont = 0;

        while (atual != null) {
            while (atual != null && !inseriu) {
                if (atual.getInfo() == value) {
                    Node novo = new Node(value);
                    novo.setNext(atual.getNext());
                    atual.setNext(novo);
                    inseriu = true;
                    cont++;
                } else {
                    anterior = atual;
                    atual = atual.getNext();
                }
            }
            anterior = atual;
            atual = atual.getNext();
            cont++;
            if (cont == 3) inseriu = false;
        }
    }

    public void removeDuplicate(char value) {
        Node anterior = head;
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == value && anterior.getInfo() == value){
                anterior.setNext(atual.getNext());
            }
            anterior = atual;
            atual = atual.getNext();
        }
    }

    public void show() {
        Node atual = head.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }



    public int countWords() {
        return countWords(head.getNext()) + 1;
    }

    private int countWords(Node atual) {
        if (atual == null) {
            return 0;
        } else {
            if (atual.getInfo() == ' ') {
                return countWords(atual.getNext()) + 1;
            } else {
                return countWords(atual.getNext());
            }
        }

    }
}
