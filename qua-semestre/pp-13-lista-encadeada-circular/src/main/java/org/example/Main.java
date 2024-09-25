package org.example;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        // Inserindo os soldados na lista circular
        lista.insereNode("A");
        lista.insereNode("B");
        lista.insereNode("C");
        lista.insereNode("D");
        lista.insereNode("E");

        // Exibe a lista de soldados
        System.out.println("Soldados no círculo:");
        lista.exibe();

        // Aplicar o problema de Josephus com n = 3 e iniciando em A
        System.out.println("\nResultado do problema de Josephus:");
        lista.josephus("A", 3);
    }
}