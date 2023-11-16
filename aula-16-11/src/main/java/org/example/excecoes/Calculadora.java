package org.example.excecoes;

public class Calculadora {

    public Integer dividir(Integer n1, Integer n2) throws DivisaoPorZeroException{
        try {
            return n1 / n2;
        } catch (ArithmeticException e){
            throw new DivisaoPorZeroException(e);
        }
    }
}
