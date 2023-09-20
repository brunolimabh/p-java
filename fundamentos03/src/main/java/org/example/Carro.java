package org.example;

import java.lang.invoke.StringConcatFactory;

public class Carro {

    // não é var global
    // caracteristicas
    // atributos de instancia - caracteristicas daquela classe
    String modelo;
    String marca;
    Integer anoLancamento;

    Double velocidadeAtual = 0.0;

    // metodos
    void acelerar() {
        System.out.println("Vruuuuuummmmmmmmmm...");
        velocidadeAtual += 2.5;
    }

    void frear() {
        System.out.println("Riiiskdmsmdkdms");
        velocidadeAtual -= 2.5;

    }

}
