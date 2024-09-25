package org.example;

public class ListaCircular {
    private Node head;
    private int tamanho;

    public ListaCircular() {
        this.head = new Node(null);
        this.head.next = head;
        this.tamanho = 0;
    }

    public void insereNode(String valor) {
        Node novo = new Node(valor);
        if (tamanho == 0) {
            head.next = novo;
        } else {
            Node x = head.next;
            while (x.next != head) {
                x = x.next;
            }
            x.next = novo;
        }
        novo.next = head;
        tamanho++;
    }

    public void exibe() {
        if (tamanho == 0) {
            System.out.println("Lista vazia");
            return;
        }
        Node atual = head.next;
        do {
            System.out.print(atual.info + " ");
            atual = atual.next;
        } while (atual != head);
    }

    public boolean removeNode(String valor) {
        if (tamanho == 0) {
            return false;
        }
        Node atual = head;
        Node anterior;
        do {
            anterior = atual;
            atual = atual.next;
            if (atual.info.equals(valor)) {
                anterior.next = atual.next;
                tamanho--;
                return true;
            }
        } while (atual != head);
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void josephus(String inicio, int n) {
        if (tamanho == 0) {
            System.out.println("Lista está vazia.");
            return;
        }

        Node atual = head.next;

        while (!atual.info.equals(inicio)) {
            atual = atual.next;
        }

        while (tamanho > 1) {
            for (int i = 1; i < n; i++) {
                atual = atual.next;
                if (atual == head) {
                    atual = atual.next;
                }
            }
            System.out.println("Eliminado: " + atual.info);
            removeNode(atual.info);
            atual = atual.next;
            if (atual == head) {
                atual = atual.next;
            }
        }
        System.out.println("Soldado restante: " + head.next.info);
    }
}
