package org.example;

import java.util.Objects;

public class Calculadora {

    public Integer somar(Integer valor1, Integer valor2) {
        if (Objects.isNull(valor1) || Objects.isNull(valor2)){
            throw new ValorInvalidoException("valores não podem ser nulos");
        }
        return valor1 + valor2;
    }
}
