package org.example;

public class App {
    public static void main(String[] args) {
        Heroi miranha = new Heroi("Miranha","Peter Parker");
        miranha.adicionarPoder("Soltar Teia",4);
        miranha.adicionarPoder("Andar em paredes",2);
        miranha.adicionarPoder("Sentido aranha",6);
        miranha.getForcaTotal();
        System.out.println("-".repeat(15));
        System.out.println(miranha);
        System.out.println(miranha.getForcaTotal());
        System.out.println("-".repeat(15));

        Heroi morcegao = new Heroi("Morcegão","Bruce wayne");
        morcegao.adicionarPoder("Intelecto de gênio",10);
        morcegao.adicionarPoder("Dinheiro",9);
        System.out.println("-".repeat(15));
        System.out.println(morcegao);
        System.out.println(morcegao.getForcaTotal());
        System.out.println("-".repeat(15));

        Vilao coringa = new Vilao("Mc Guime","Arthur Fleck");
        coringa.adicionarPoder("Gás do riso",8);
        System.out.println("-".repeat(15));
        System.out.println(coringa);
        System.out.println(coringa.getPoderes());
        System.out.println(coringa.getForcaTotal());
        System.out.println("-".repeat(15));

        Vilao tobi = new Vilao("Tobi","Pain");
        tobi.adicionarPoder("Shinra Tensei",9);
        tobi.adicionarPoder("Banshō Ten'in",9);
        System.out.println("-".repeat(15));
        System.out.println(tobi);
        System.out.println(tobi.getPoderes());
        System.out.println(tobi.getForcaTotal());
        System.out.println("-".repeat(15));

        Confronto batalha = new Confronto();
        System.out.println("Miranha x Tobi");
        batalha.lutar(miranha,tobi);
        System.out.println("Morcegão x Coringa");
        batalha.lutar(morcegao,coringa);
    }
}