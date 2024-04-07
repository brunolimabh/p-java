package org.example;

import java.util.Arrays;
import java.util.List;

public class Ordenacao {

    public static void ordenarPesoMerge(int p, int r, Funcionario[] v){
        if (p < r - 1) {
            int q = (p + r) / 2;
            ordenarPesoMerge(p, q, v);
            ordenarPesoMerge(q, r, v);
            intercala(p, q, r, v);
        }
    };

    public static void intercala(int p, int q, int r, Funcionario[] v){
        Funcionario [] w = new Funcionario[r - p];
        int i = p;
        int j = q;
        int k = 0;
        while (i < q && j < r) {
            if (v[i].getPeso() <= v[j].getPeso()) {
                w[k++] = v[i++];
            } else {
                w[k++] = v[j++];
            }
        }
        while (i < q) {
            w[k++] = v[i++];
        }
        while (j < r) {
            w[k++] = v[j++];
        }
        for (i = p; i < r; i++) {
            v[i] = w[i - p];
        }
    };

    public static void ordenarSalarioQuick(Funcionario[] v, int indInicio, int indFim){
        if (indInicio < indFim) {
            int indicePivo = particiona(v, indInicio, indFim);
            ordenarSalarioQuick(v, indInicio, indicePivo - 1);
            ordenarSalarioQuick(v, indicePivo + 1, indFim);
        }
    };

    public static int particiona(Funcionario[] v, int indInicio, int indFim) {
        double pivo = v[indFim].getSalario();
        int i = indFim;
        for (int j = indFim - 1; j >= indInicio; j--) {
            if (v[j].getSalario() > pivo) {
                i--;
                troca(v, i, j);
            }
        }
        troca(v, indFim, i);
        return i;
    }

    public static void troca(Funcionario[] v, int i, int j) {
        Funcionario temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}

