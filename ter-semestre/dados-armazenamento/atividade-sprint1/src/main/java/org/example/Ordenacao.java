package org.example;

import java.util.Arrays;
import java.util.List;

public class Ordenacao {

    public Funcionario[] ordenarPorPeso(Funcionario[] v) {
        for (int i = 0; i < v.length -1; i++) {
            int indiceMenor = i;
            for (int j = i+1; j < v.length; j++) {
                if (v[j].getPeso() < v[indiceMenor].getPeso()){
                    indiceMenor = j;
                }
            }
            if (v[indiceMenor] != v[i]){
                Funcionario aux = v[i];
                v[i] = v[indiceMenor];
                v[indiceMenor] = aux;
            }
        }
        return v;
    }
    public Funcionario[] ordenarPorNome(Funcionario[] v){
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length -1; j++) {
                if (v[j+1].getNome().compareTo(v[j].getNome()) < 0){
                    Funcionario aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return v;
    }
    public int pesquisaBinaria(Funcionario[] v, String x){
        int indiceInicio = 0;
        int indiceFim = v.length-1;

        while (indiceInicio <= indiceFim){
            int indiceMeio = (indiceInicio + indiceFim) / 2;
            int comparacao = x.compareToIgnoreCase(v[indiceMeio].getNome());
            if (comparacao == 0){
                return indiceMeio;
            } else if (comparacao > 0){
                indiceInicio = indiceMeio+1;
            } else {
                indiceFim = indiceMeio-1;
            }
        }
        return -1;
    }
}
