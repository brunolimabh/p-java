package org.example;

public class HashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(26);

        Musica m1 = new Musica(1, "De onde vem a paz","Os Arrais", 4.44,"Rastros e Trilha");
        Musica m2 = new Musica(2, "Terra","Naielly", 3.38,"Terra");
        Musica m3 = new Musica(3, "Justiça e Poder","Valente", 3.35,"Reversos");

        hashTable.inserePorNome(m1);
        hashTable.inserePorNome(m2);
        hashTable.inserePorNome(m3);

        System.out.println("Exibindo músicas:");
        hashTable.exibe();

        System.out.println("Buscando música por nome : " + hashTable.buscaPorNome("Terra"));
        System.out.println("Removendo música por nome: " + hashTable.removerPorNome("De onde vem a paz"));

        System.out.println("Exibindo músicas:");
        hashTable.exibe();
    }

    private ListaLigadaObj tab[];
    private int tam;

    public HashTable(int capacidade) {
        this.tab = new ListaLigadaObj[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tab[i] = new ListaLigadaObj();
        }
    }

    public int funcaoHashPorId(int x) {
        return x % getSize();
    }

    public int funcaoHashPorNome(String nome) {
        return nome.toUpperCase().charAt(0) - 'A';
    }

    public void inserePorId(Musica musica) {
        int index = funcaoHashPorId(musica.getId());
        tab[index].insereNode(musica);
    }

    public void inserePorNome(Musica musica) {
        int index = funcaoHashPorNome(musica.getNome());
        tab[index].insereNode(musica);
    }

    public boolean buscaPorId(int id) {
        int index = funcaoHashPorId(id);
        Object musica = tab[index].buscaNode(id);
        return musica != null;
    }

    public boolean buscaPorNome(String nome) {
        int index = funcaoHashPorNome(nome);
        Object musica = tab[index].buscaNode(nome);
        return musica != null;
    }

    public boolean removerPorId(int id) {
        int index = funcaoHashPorId(id);
        return tab[index].removeNode(id);
    }

    public boolean removerPorNome(String nome) {
        int index = funcaoHashPorNome(nome);
        return tab[index].removeNode(nome);
    }

    public void exibe() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println("Entrada " + i + ": ");
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
