package org.example;

public class PilhaLigadaEx {
    public static void main(String[] args) {
        PilhaLigada pilha = new PilhaLigada();

        // Testando isEmpty
        System.out.println("A pilha está vazia? " + pilha.isEmpty());

        // Inserindo elementos na pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        // Exibindo a pilha
        System.out.println("Elementos na pilha:");
        pilha.exibe();

        // Testando peek
        System.out.println("Elemento no topo: " + pilha.peek());

        // Removendo elemento do topo
        System.out.println("Elemento removido: " + pilha.pop());

        // Exibindo a pilha após remoção
        System.out.println("Elementos na pilha após remoção:");
        pilha.exibe();

        // Testando isEmpty novamente
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
    }
}