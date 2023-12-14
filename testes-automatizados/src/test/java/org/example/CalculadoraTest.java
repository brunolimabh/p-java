package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    @DisplayName("Somar quando acionado com valor 2+2 deve retornar 4")
    void somarQuandoAcionadoComValor2e2DeveRetornar4(){
        // 3 A's

        // Arrange
        Calculadora calc = new Calculadora();
        Integer valor1 = 2;
        Integer valor2 = 2;
        Integer valorEsperado = 4;

        // Act
        Integer resultado = calc.somar(valor1, valor2);

        // Assert
        assertEquals(valorEsperado, resultado);
    }

    @Test
    @DisplayName("Somar quando acionado com valores nulos deve lançar IllegalArgumentException")
    void somarQuandoAcionadoComValoresNulosDeveLancarException(){
        // Arrange
        Calculadora calc = new Calculadora();
        String mensagemEsperada = "valores não podem ser nulos";

        // Act e Assert
        ValorInvalidoException exception = assertThrows(
                ValorInvalidoException.class,
                () -> calc.somar(null,null)
        );

        String mensagem = exception.getMessage();
        assertEquals(mensagemEsperada,mensagem);
    }
}