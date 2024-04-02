package org.example;

import java.util.Arrays;

public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tam) {
        this.vetor = new int[tam];
        this.nroElem = 0;
    }

    public void add(int numero){
        if (nroElem != vetor.length){
            vetor[nroElem++] = numero;
        }
    }

    public String list(){
        return Arrays.toString(vetor);
    }

    public int src(int element){
        for (int i = 0; i < vetor.length; i++) {
            if (element == vetor[i]){
                return i;
            }
        }
        return -1;
    }

    public boolean removeIndice(int indice){
        if (indice < nroElem && indice >= 0){
            for (int i = indice; i <= vetor.length - 1 ; i++) {
                if (i == vetor.length -1){
                    vetor[i] = 0;
                } else {
                    vetor[i] = vetor[i+1];
                }
            }
            return true;
        }
        return false;
    }

    public boolean removeElement(int element){
        int indice = src(element);
        if (indice != -1) removeIndice(indice);
        return false;
    }
}

