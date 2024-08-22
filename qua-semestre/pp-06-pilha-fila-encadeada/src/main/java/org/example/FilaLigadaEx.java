package org.example;

public class FilaLigadaEx {
    public static void main(String[] args) {
        FilaLigada fila = new FilaLigada();

        // Testando isEmpty
        System.out.println("A fila está vazia? " + fila.isEmpty());

        // Inserindo elementos na fila
        fila.insert(10);
        fila.insert(20);
        fila.insert(30);

        // Exibindo a fila
        System.out.println("Elementos na fila:");
        fila.exibe();

        // Testando peek
        System.out.println("Elemento no início: " + fila.peek());

        // Removendo elemento do início
        System.out.println("Elemento removido: " + fila.poll());

        // Exibindo a fila após remoção
        System.out.println("Elementos na fila após remoção:");
        fila.exibe();

        // Testando isEmpty novamente
        System.out.println("A fila está vazia? " + fila.isEmpty());
    }
}