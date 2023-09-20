package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProgressaoAritmetica {

    private Integer primeiroTermo;
    private Integer razao;

    private List<Integer> listaTermo = new ArrayList<>();

    public ProgressaoAritmetica(Integer primeiroTermo, Integer razao) {
        this.primeiroTermo = primeiroTermo;
        this.razao = razao;
    }

    public void calcularTermo(Integer qtdTermos) {
        for (int i = 0; i < qtdTermos; i++) {
            if (i == 0) {
                listaTermo.add(primeiroTermo);
            } else {
                listaTermo.add((listaTermo.get(i-1))+razao);
            }
        }
    }

    public List<Integer> getListaTermo() {
        return listaTermo;
    }
}
