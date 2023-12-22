package school.sptech;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.utils.ProdutoInternacionalUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("2. Encapsulamento")
public class EncapsulamentoTests {

    @Nested
    @DisplayName("2.3 Produto Internacional")
    public class ProdutoInternacionalEncapsulamentoTest {

        @Test
        @DisplayName("Cenário 1: paisOrigem deve ser privado e TaxaImportacao deve ser publico e final")
        void cenario1() throws NoSuchFieldException {

            Class<ProdutoInternacional> clazz = ProdutoInternacional.class;

            Field campoPaisOrigem = clazz.getDeclaredField(ProdutoInternacionalUtils.ATRIBUTO_PAIS_ORIGEM);
            Field campoTaxaImportacao = clazz.getDeclaredField(ProdutoInternacionalUtils.ATRIBUTO_TAXA_IMPORTACAO);

            assertTrue(Modifier.isPrivate(campoPaisOrigem.getModifiers()));

            assertTrue(Modifier.isPublic(campoTaxaImportacao.getModifiers()));
            assertTrue(Modifier.isFinal(campoTaxaImportacao.getModifiers()));
        }

        @Test
        @DisplayName("Cenário 2: todos os atributos devem ter métodos de acesso GET e SET")
        void cenario2() throws NoSuchMethodException {

            Class<ProdutoInternacional> clazz = ProdutoInternacional.class;

            Field[] fields = clazz.getDeclaredFields();

            assertNotEquals(0, fields.length);

            List<Field> filteredFields = Arrays.stream(fields).filter(field -> field.getModifiers() == Modifier.PRIVATE)
                    .toList();

            for (Field field : filteredFields) {

                String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
                String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

                Method getter = clazz.getDeclaredMethod(getName);
                Method setter = clazz.getDeclaredMethod(setName, field.getType());

                int getModifier = getter.getModifiers();
                int setModifier = setter.getModifiers();

                Assertions.assertTrue(Modifier.isPublic(getModifier));
                Assertions.assertTrue(Modifier.isPublic(setModifier));
            }
        }

        @Test
        @DisplayName("Cenário 3: A classe Produto deve conter um construtor cheio que inicialize todos os atributos")
        void cenario3() throws NoSuchMethodException {

            Class<ProdutoInternacional> clazz = ProdutoInternacional.class;
            Constructor<?>[] constructors = clazz.getConstructors();

            Assertions.assertTrue(constructors.length > 0);

            boolean hasFullConstructor = Arrays.stream(constructors)
                    .anyMatch(constructor -> {
                        Parameter[] parameters = constructor.getParameters();

                        long qtdString = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(String.class))
                                .count();

                        long qtdDouble = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Double.class))
                                .count();

                        long qtdDoublePrimitvo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(double.class))
                                .count();

                        long qtdInteger = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Integer.class))
                                .count();

                        long qtdIntegerPrimitivo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(int.class))
                                .count();

                        boolean hasInt = qtdIntegerPrimitivo == 1 || qtdInteger == 1;
                        boolean hasDouble = qtdDoublePrimitvo == 1 || qtdDouble == 1;
                        boolean hasString = qtdString == 5;

                        return (hasString && hasDouble && hasInt);
                    });

            Assertions.assertTrue(hasFullConstructor);
        }
    }

    @Nested
    @DisplayName("2.2 Produto Nacional")
    public class ProdutoNacionalEncapsulamentoTest {

        @Test
        @DisplayName("Cenário 1: Todos os atributos devem ser privados")
        void cenario1() {

            Class<ProdutoNacional> clazz = ProdutoNacional.class;

            Field[] fields = clazz.getDeclaredFields();

            assertNotEquals(0, fields.length);

            Arrays.stream(fields).forEach(field ->
                assertTrue(Modifier.isPrivate(field.getModifiers())));
        }

        @Test
        @DisplayName("Cenário 2: todos os atributos devem ter métodos de acesso GET e SET")
        void cenario2() throws NoSuchMethodException {

            Class<ProdutoNacional> clazz = ProdutoNacional.class;

            Field[] fields = clazz.getDeclaredFields();

            assertNotEquals(0, fields.length);

            List<Field> filteredFields = Arrays.stream(fields).filter(field -> field.getModifiers() == Modifier.PRIVATE)
                    .toList();

            for (Field field : filteredFields) {

                String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
                String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

                Method getter = clazz.getDeclaredMethod(getName);
                Method setter = clazz.getDeclaredMethod(setName, field.getType());

                int getModifier = getter.getModifiers();
                int setModifier = setter.getModifiers();

                Assertions.assertTrue(Modifier.isPublic(getModifier));
                Assertions.assertTrue(Modifier.isPublic(setModifier));
            }
        }

        @Test
        @DisplayName("Cenário 3: A classe Produto deve conter um construtor cheio que inicialize todos os atributos")
        void cenario3() throws NoSuchMethodException {

            Class<ProdutoNacional> clazz = ProdutoNacional.class;
            Constructor<?>[] constructors = clazz.getConstructors();

            Assertions.assertTrue(constructors.length > 0);

            boolean hasFullConstructor = Arrays.stream(constructors)
                    .anyMatch(constructor -> {
                        Parameter[] parameters = constructor.getParameters();

                        long qtdString = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(String.class))
                                .count();

                        long qtdDouble = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Double.class))
                                .count();

                        long qtdDoublePrimitvo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(double.class))
                                .count();

                        long qtdInteger = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Integer.class))
                                .count();

                        long qtdIntegerPrimitivo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(int.class))
                                .count();

                        boolean hasInt = qtdIntegerPrimitivo == 1 || qtdInteger == 1;
                        boolean hasDouble = qtdDoublePrimitvo == 1 || qtdDouble == 1;
                        boolean hasString = qtdString == 5;

                        return (hasString && hasDouble && hasInt);
                    });

            Assertions.assertTrue(hasFullConstructor);
        }
    }

    @Nested
    @DisplayName("2.1 Produto")
    public class ProdutoEncapsulamentoTest {

        @Test
        @DisplayName("Cenário 1: todos os atributos devem ser privados")
        void cenario1() {

            Class<Produto> clazz = Produto.class;

            Field[] campos = clazz.getDeclaredFields();

            assertNotEquals(0, campos.length);

            for (Field campo : campos) {
                assertTrue(Modifier.isPrivate(campo.getModifiers()));
            }
        }

        @Test
        @DisplayName("Cenário 2: todos os atributos devem ter métodos de acesso GET e SET")
        void cenario2() throws NoSuchMethodException {

            Class<Produto> clazz = Produto.class;

            Field[] fields = clazz.getDeclaredFields();

            assertNotEquals(0, fields.length);

            for (Field field : fields) {

                String getName = String.format("get%s", StringUtils.capitalize(field.getName()));
                String setName = String.format("set%s", StringUtils.capitalize(field.getName()));

                Method getter = clazz.getDeclaredMethod(getName);
                Method setter = clazz.getDeclaredMethod(setName, field.getType());

                int getModifier = getter.getModifiers();
                int setModifier = setter.getModifiers();

                Assertions.assertTrue(Modifier.isPublic(getModifier));
                Assertions.assertTrue(Modifier.isPublic(setModifier));
            }
        }

        @Test
        @DisplayName("Cenário 3: A classe Produto deve conter um construtor cheio que inicialize todos os atributos")
        void cenario3() throws NoSuchMethodException {

            Class<Produto> clazz = Produto.class;
            Constructor<?>[] constructors = clazz.getConstructors();

            Assertions.assertTrue(constructors.length > 0);

            boolean hasFullConstructor = Arrays.stream(constructors)
                    .anyMatch(constructor -> {
                        Parameter[] parameters = constructor.getParameters();

                        long qtdString = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(String.class))
                                .count();

                        long qtdDouble = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Double.class))
                                .count();

                        long qtdDoublePrimitvo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(double.class))
                                .count();

                        long qtdInteger = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(Integer.class))
                                .count();

                        long qtdIntegerPrimitivo = Arrays.stream(parameters)
                                .filter(parameter -> parameter.getType().equals(int.class))
                                .count();

                        boolean hasInt = qtdIntegerPrimitivo == 1 || qtdInteger == 1;
                        boolean hasDouble = qtdDoublePrimitvo == 1 || qtdDouble == 1;
                        boolean hasString = qtdString == 4;

                        return (hasString && hasDouble && hasInt);
                    });

            Assertions.assertTrue(hasFullConstructor);
        }
    }
}
