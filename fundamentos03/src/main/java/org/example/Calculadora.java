package org.example;

public class Calculadora {

    Integer numeroOperacoes = 0;

    Integer somar(Integer n1, Integer n2){
        numeroOperacoes++;
        return n1+n2;
    }
    Integer subtrair(Integer n1, Integer n2){
        numeroOperacoes++;
        return n1-n2;
    }
    Integer multiplicar(Integer n1, Integer n2){
        numeroOperacoes++;
        return n1*n2;
    }
    Integer dividir(Integer n1, Integer n2){
        numeroOperacoes++;
        return n1/n2;
    }
}
