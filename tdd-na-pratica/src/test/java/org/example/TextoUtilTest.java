package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("TextoUtel")
class TextoUtilTest {
    @Test
    @DisplayName("Cenário 1 - Contar Palavras")
    void contarPalavras(){
        TextoUtil textoUtil = new TextoUtil();
        String teste = "testes testes";
        Integer resultadoEsperado = 2;

        Integer resultado = textoUtil.contarPalavras(teste);

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    @DisplayName("Cenário 2 - Inverter")
    void    inverter(){
        TextoUtil textoUtil = new TextoUtil();
        String teste = "testes";

        String resultado = textoUtil.inverter(teste);
        String resultadoEsperado = "setset";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    @DisplayName("Cenário 3 - Capitalizar")
    void capitalizar(){
        TextoUtil textoUtil = new TextoUtil();
        String teste = "testes";

        String resultado = textoUtil.capitalizar(teste);
        String resultadoEsperado = "Testes";

        assertEquals(resultadoEsperado, resultado);
    }


}