package org.example;

public class ListaObj <T> {

    private T[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;

    }

    public void adiciona(T elemento) {
        if (nroElem < vetor.length){
            vetor[nroElem++] = elemento;
        } else {
            throw new IllegalStateException("Lista cheia");
        }
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) return i;
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < nroElem && indice >= 0){
            for (int i = indice; i <= vetor.length - 1 ; i++) {
                if (i == vetor.length -1){
                    vetor[i] = (T) "buraco";
                } else {
                    vetor[i] = vetor[i+1];
                }
            }
            nroElem--;
            return true;
        }
        return false;
    }

    public boolean removeElemento(T elementoARemover) {
        int indice = busca(elementoARemover);
        if (indice != -1) {
            removePeloIndice(indice);
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice >= 0 && indice < nroElem) return vetor[indice];
        return null;
    }

    public void limpa() {
        this.vetor = (T[]) new Object[vetor.length];
        nroElem = 0;

    }

    public void exibe() {
        for (Object valor: vetor) {
            System.out.println(valor);
        }
    }

    public T[] getVetor() {
        return vetor;
    }
}
