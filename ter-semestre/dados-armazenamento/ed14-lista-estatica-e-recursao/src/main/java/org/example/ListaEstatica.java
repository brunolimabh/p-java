package org.example;

import java.util.Arrays;
import java.util.List;

public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }

    public void adiciona(int elemento){
        if (nroElem < vetor.length){
            vetor[nroElem++] = elemento;
        } else {
            throw new IllegalStateException("Lista cheia");
        }
    }

    public int busca(int elemento){
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == elemento) return i;
        }
        return -1;
    }
    public void buscaRecursiva(int elemento){
        buscaRecursiva(elemento,0);
    }
    private void buscaRecursiva(int elemento, int indice){
        if (indice < nroElem){
            if (vetor[indice] == elemento) {
                System.out.println(indice);
                buscaRecursiva(elemento, indice + 1);
            }
        } else {
            System.out.println(-1);
        }
    }

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

    public void removePeloIndiceRecursivo(int indice){
        if (indice < nroElem){
            if (indice == nroElem -1){
                vetor[indice] = 0;
            } else {
                vetor[indice] = vetor[indice + 1];
            }
            removePeloIndiceRecursivo(indice + 1);
        }
    }

    public boolean removeElemento(int elemento){
        int indice = busca(elemento);
        if (indice != -1) {
            removePeloIndice(indice);
            return true;
        }
        return false;
    }

    public String exibe(){
        return Arrays.toString(vetor);
    }
    public void exibeRecursivo() {
        if (nroElem == 0) System.out.println("Lista vazia");
        exibeRecursivo(0);
    }
    private void exibeRecursivo(int indInicial) {
        if (indInicial < nroElem) {
            System.out.println(vetor[indInicial]);
            exibeRecursivo(indInicial + 1);
        }
    }

    public boolean substitui(int antigo, int novo){
        int indice = busca(antigo);
        if (indice >= 0 ){
            vetor[indice] = novo;
            return true;
        }
        return false;
    }

    public int contaOcorrencias(int valor){
        int qtd = 0;
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == valor) qtd++;
        }
        return qtd;
    }
    public void contaOcorrenciasRecursivo(int valor){
        contaOcorrenciasRecursivo(valor, 0, 0);
    }
    private void contaOcorrenciasRecursivo(int valor, int indice, int qtd){
        if (indice >= nroElem){
            System.out.println(qtd);
        } else {
            if (vetor[indice] == valor){
                qtd++;
            }
            contaOcorrenciasRecursivo(valor, indice + 1, qtd);
        }
    }

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
    public void adicionaNoInicioRecursivo(int valor){
        adicionaNoInicioRecursivo(valor, nroElem - 1);

    }
    private void adicionaNoInicioRecursivo(int valor, int indice){
        if (indice == 0) {
            vetor[indice] = valor;
        } else {
            vetor[indice] = vetor[indice - 1];
            adicionaNoInicioRecursivo(valor, indice - 1);
        }
    }


    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }
}