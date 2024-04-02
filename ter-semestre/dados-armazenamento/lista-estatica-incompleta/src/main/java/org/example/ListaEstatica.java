package org.example;

import java.util.Arrays;

public class ListaEstatica {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private int[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem

    public ListaEstatica(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }


    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(int elemento){
        if (nroElem < vetor.length){
            vetor[nroElem++] = elemento;
        } else {
            throw new IllegalStateException("Lista cheia");
        }
    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public int busca(int elemento){
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == elemento) return i;
        }
        return -1;
    }


    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public boolean removePeloIndice(int indice){
        if (indice < nroElem && indice >= 0){
            for (int i = indice; i <= vetor.length - 1 ; i++) {
                if (i == vetor.length -1){
                    vetor[i] = 0;
                } else {
                    vetor[i] = vetor[i+1];
                }
            }
            nroElem--;
            return true;
        }
        return false;
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(int elemento){
        int indice = busca(elemento);
        if (indice != -1) {
            removePeloIndice(indice);
            return true;
        }
        return false;
    }

    // 08 Método exibe:
    // Exibe os elementos da lista
    public String exibe(){
        return Arrays.toString(vetor);
    }

    // a Método substitui:
    // Este método deve ser do tipo boolean e deve receber 2 argumentos: o valor antigo e o valor novo (ambos inteiros)
    // O método deve procurar o valor antigo na lista e, se encontrar, deve substituí-lo pelo valor novo e retornar true
    // Se o valor antigo não for encontrado, deve exibir uma mensagem de “valor não encontrado” e retornar false
    public boolean substitui(int antigo, int novo){
        int indice = busca(antigo);
        if (indice >= 0 ){
            vetor[indice] = novo;
            return true;
        }
        return false;
    }

    // b Método contaOcorrencias:
    // Este método deve ser do tipo inteiro e deve receber um valor inteiro.
    // O método deve “contar” quantas vezes o valor recebido como argumento aparece na lista e deve retornar essa quantidade.
    public int contaOcorrencias(int valor){
        int qtd = 0;
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == valor) qtd++;
        }
        return qtd;
    }

    // c Método adicionaNoInicio
    // Este método deve ser do tipo boolean e deve receber um valor inteiro que será adicionado no início da lista.
    // O método deve exibir a mensagem “Lista cheia” se a lista estiver cheia.
    // Senão, deve inserir o valor recebido como argumento no início da lista, no índice zero, deslocando para frente os valores que já estão na lista.
    public boolean adicionaNoInicio(int valor){
        if (nroElem < vetor.length){
            for (int i = vetor.length - 1; i >= 0 ; i--) {
                if (i == 0){
                    vetor[i] = valor;
                } else {
                    vetor[i] = vetor[i-1];
                }
            }
            nroElem++;
            return true;
        }
        return false;

    }

    //Métodos getVetor e getNroElem
    //São usados nos testes
    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }
}
