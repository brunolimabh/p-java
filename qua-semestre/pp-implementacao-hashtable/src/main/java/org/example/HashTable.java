package org.example;

public class HashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10); // Cria uma tabela de hash com 10 entradas

        hashTable.insere(15);
        hashTable.insere(25);
        hashTable.insere(35);
    }

    private ListaLigada tab[];
    private int tam;

    public HashTable(int capacidade) {
        this.tab = new ListaLigada[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tab[i] = new ListaLigada();
        }
    }

    public int funcaoHash(int x) {
        return x % getSize();
    }

    public void insere(int x) {
        int index = funcaoHash(x);
        tab[index].insereNode(x);
    }

    public boolean busca(int x) {
        int index = funcaoHash(x);
        Node node = tab[index].buscaNode(x);
        return node != null;
    }

    public boolean remover(int x) {
        int index = funcaoHash(x);
        return tab[index].removeNode(x);
    }

    public void exibe() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println("Entrada" + i + ": ");
            if (tab[i].getTamanho() == 0) {
                System.out.println("Lista vazia");
            } else {
                tab[i].exibe();
                System.out.println("");
            }
        }
    }

    public int getSize() {
        return tab.length;
    }
}
