package school.sptech.marketplaceresumido.service.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Deve retonar 18 ao passar 100 com base no calculo ICMS")
    void retornaCerto() {
        CalculadoraService calculadora = new CalculadoraService();

        Double retorno = calculadora.icms(100.0);

        Assertions.assertEquals(18.0, retorno);
    }

    @Test
    @DisplayName("Deve retornar exception ao passar valor nulo")
    void retornaExceptionAoSerNull() {
        CalculadoraService calculadora= new CalculadoraService();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                () -> calculadora.icms(null)
        );

        assertEquals("Não pode ser nulo", exception.getMessage());


    }

    @Test
    @DisplayName("Deve retornar exception ao passar valor negativo")
    void retornaExceptionValorNegativo() {
        CalculadoraService calculadora= new CalculadoraService();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> calculadora.icms(-1.0)
                );

        assertEquals("Não pode ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar exception ao passar valor 0")
    void retornaExceptionAoPassarZero() {
        CalculadoraService calculadora= new CalculadoraService();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> calculadora.icms(0.0)
                );

        assertEquals("Não pode ser zero", exception.getMessage());
    }

}