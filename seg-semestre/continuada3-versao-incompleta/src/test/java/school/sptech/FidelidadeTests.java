package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.utils.CarrinhoUtils;
import school.sptech.utils.Metodo;
import school.sptech.utils.ProdutoInternacionalUtils;
import school.sptech.utils.ProdutoNacionalUtils;
import school.sptech.utils.ProdutoUtils;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("1. Fidelidade a especificação")
public class FidelidadeTests {

    @Nested
    @DisplayName("1.4 Carrinho")
    public class CarrinhoFidelidadeTest {

        @Test
        @DisplayName("Cenário 2: Deve respeitar o nomes de metodos especificados")
        void cenario2() {

            Class<Carrinho> clazz = Carrinho.class;

            List<Metodo> metodos = CarrinhoUtils.getMetodoImplementacoes();

            for (Metodo metodo : metodos) {
                assertDoesNotThrow(() -> clazz.getDeclaredMethod(metodo.getNome(), metodo.getArgs()));
            }
        }

        @Test
        @DisplayName("Cenário 1: Deve respeitar o nomes de atributos especificados")
        void cenario1() {
            Class<Carrinho> clazz = Carrinho.class;
            List<String> atributos = CarrinhoUtils.getAtributos();
            for (String atributo : atributos) {
                assertDoesNotThrow(() -> clazz.getDeclaredField(atributo));
            }
        }
    }

    @Nested
    @DisplayName("1.3 ProdutoInternacional")
    public class ProdutoInternacionalFidelidadeTest {

        @Test
        @DisplayName("Cenário 1: Deve ser subclasse de Produto")
        void cenario1() {
            Class<ProdutoInternacional> clazz = ProdutoInternacional.class;
            Class<?> superClass = Produto.class;
            assertTrue(superClass.isAssignableFrom(clazz));
        }

        @Test
        @DisplayName("Cenário 2: Deve respeitar o nomes de atributos especificados")
        void cenario2() {
            Class<ProdutoInternacional> clazz = ProdutoInternacional.class;
            List<String> atributos = ProdutoInternacionalUtils.getAtributos();
            for (String atributo : atributos) {
                assertDoesNotThrow(() -> clazz.getDeclaredField(atributo));
            }
        }
    }

    @Nested
    @DisplayName("1.2 ProdutoNacional")
    public class ProdutoNacionalUtilsFidelidadeTest {

        @Test
        @DisplayName("Cenário 1: Deve ser subclasse de Produto")
        void cenario1() {
            Class<ProdutoNacional> clazz = ProdutoNacional.class;
            Class<?> superClass = Produto.class;
            assertTrue(superClass.isAssignableFrom(clazz));
        }

        @Test
        @DisplayName("Cenário 2: Deve respeitar o nomes de atributos especificados")
        void cenario2() {
            Class<ProdutoNacional> clazz = ProdutoNacional.class;

            List<String> atributos = ProdutoNacionalUtils.getAtributos();

            for (String atributo : atributos) {
                assertDoesNotThrow(() -> clazz.getDeclaredField(atributo));
            }
        }
    }

    @Nested
    @DisplayName("1.1 Produto")
    public class ProdutoFidelidadeTest {

        @Test
        @DisplayName("Cenário 1: Deve respeitar o nomes de atributos especificados")
        void cenario1() {
            Class<Produto> clazz = Produto.class;
            List<String> atributos = ProdutoUtils.getAtributos();
            for (String atributo : atributos) {
                assertDoesNotThrow(() -> clazz.getDeclaredField(atributo));
            }
        }

        @Test
        @DisplayName("Cenário 2: Deve respeitar o nomes de métodos especificados")
        void cenario2() {

            Class<Produto> clazz = Produto.class;
            List<String> metodos = ProdutoUtils.getMetodos();
            for (String metodo : metodos) {
                assertDoesNotThrow(() -> clazz.getDeclaredMethod(metodo));
            }
        }

        @Test
        @DisplayName("Cenário 3: Classe deve ser abstrata (abstract)")
        void cenario3() {
            Class<Produto> clazz = Produto.class;
            assertTrue(Modifier.isAbstract(clazz.getModifiers()));
        }

        @Test
        @DisplayName("Cenário 4: Métodos devem ser abstratos (abstract)")
        void cenario4() throws NoSuchMethodException {
            Class<Produto> clazz = Produto.class;
            List<String> metodos = ProdutoUtils.getMetodos();

            for (String metodo : metodos) {
                assertTrue(Modifier.isAbstract(clazz.getDeclaredMethod(metodo).getModifiers()));
            }

            assertTrue(Modifier.isAbstract(clazz.getModifiers()));
        }
    }
}
