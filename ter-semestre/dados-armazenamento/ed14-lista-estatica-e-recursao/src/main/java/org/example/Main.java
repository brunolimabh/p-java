package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);
        System.out.println(lista.exibe());

        System.out.println("Buscar elemento 10 (recursivo): ");
        lista.buscaRecursiva(10);

        System.out.println("Remover pelo indice 2 (recursivo): ");
        lista.removePeloIndiceRecursivo(2);
        lista.exibeRecursivo();

        System.out.println("Contagem de ocorrencias (recursivo): ");
        lista.contaOcorrenciasRecursivo(10); //TODO

        System.out.println("Adicinar '2' no inicio (recursivo): ");
        lista.adicionaNoInicioRecursivo(2);
        lista.exibeRecursivo();
    }
}