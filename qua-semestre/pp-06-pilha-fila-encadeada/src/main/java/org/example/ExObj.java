package org.example;

public class ExObj {
    public static void main(String[] args) {
        // Testando ListaLigada com String
        ListaLigadaObj<String> lista = new ListaLigadaObj<>();
        lista.insereNode("Primeiro");
        lista.insereNode("Segundo");
        lista.insereNode("Terceiro");
        System.out.println("Elementos da ListaLigada:");
        lista.exibe();

        // Testando PilhaLigada com String
        PilhaLigadaObj<String> pilha = new PilhaLigadaObj<>();
        pilha.push("Topo");
        pilha.push("Meio");
        pilha.push("Base");
        System.out.println("\nElementos da PilhaLigada:");
        pilha.exibe();
        System.out.println("Elemento no topo: " + pilha.peek());

        // Testando FilaLigada com String
        FilaLigadaObj<String> fila = new FilaLigadaObj<>();
        fila.insert("Primeiro da Fila");
        fila.insert("Segundo da Fila");
        fila.insert("Terceiro da Fila");
        System.out.println("\nElementos da FilaLigada:");
        fila.exibe();
        System.out.println("Elemento no início: " + fila.peek());
    }
}

