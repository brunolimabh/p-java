package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import school.sptech.factory.CarrinhoFactory;
import school.sptech.factory.ProdutoInternacionalFactory;
import school.sptech.factory.ProdutoNacionalFactory;
import school.sptech.utils.CarrinhoUtils;
import school.sptech.utils.ProdutoNacionalUtils;
import school.sptech.utils.ProdutoUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("3. Implementação")
public class ImplementacaoTests {

  @Nested
  @DisplayName("3.1 ProdutoNacional")
  public class ProdutoNacional {

    @Nested
    @DisplayName("3.1.1 calcularPrecoUnitario")
    public class MetodoCalcularPrecoUnitario {

      @Test
      @DisplayName("Cenário 1: Produto - Computador Nacional")
      void cenario1() throws ReflectiveOperationException {

        Object produtoNacional = ProdutoNacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "SP");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_UNITARIO);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoNacional);

        assertEquals(2899.99, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Produto - Café Nacional")
      void cenario2() throws ReflectiveOperationException {
        Object produtoNacional = ProdutoNacionalFactory.getInstance(
            "8888777766665", "Café Pelé", "Blend exclusivo de grãos de café arábica, torrado e moído",
            "Alimentos", 29.99, 200, "MG");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_UNITARIO);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoNacional);

        assertEquals(29.99, (Double) resultado, 0.1);
      }
    }

    @Nested
    @DisplayName("3.1.2 calcularPrecoTotal")
    public class MetodoCalcularPrecoTotal {

      @Test
      @DisplayName("Cenário 1: Produto - Computador Nacional")
      void cenario1() throws ReflectiveOperationException {

        Object produtoNacional = ProdutoNacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "SP");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_TOTAL);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoNacional);

        assertEquals(144_999.5, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Produto - Café Nacional")
      void cenario2() throws ReflectiveOperationException {

        Object produtoNacional = ProdutoNacionalFactory.getInstance(
            "8888777766665", "Café Pelé", "Blend exclusivo de grãos de café arábica, torrado e moído",
            "Alimentos", 29.99, 200, "MG");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_TOTAL);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoNacional);

        assertEquals(5998, (Double) resultado, 0.1);
      }
    }
  }

  @Nested
  @DisplayName("3.2 ProdutoInternacional")
  public class ProdutoInternacional {

    @Nested
    @DisplayName("3.2.1 calcularPrecoUnitario")
    public class MetodoCalcularPrecoUnitario {

      @Test
      @DisplayName("Cenário 1: Produto - Computador Internacional")
      void cenario1() throws ReflectiveOperationException {
        Object produtoInternacional = ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_UNITARIO);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoInternacional);

        assertEquals(4_639.984, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Produto - Café Internacional")
      void cenario2() throws ReflectiveOperationException {

        Object produtoInternacional = ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_UNITARIO);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoInternacional);

        assertEquals(47.984, (Double) resultado, 0.1);
      }
    }

    @Nested
    @DisplayName("3.2.2 calcularPrecoTotal")
    public class MetodoCalcularPrecoTotal {

      @Test
      @DisplayName("Cenário 1: Produto - Computador Internacional")
      void cenario1() throws ReflectiveOperationException {
        Object produtoInternacional = ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_TOTAL);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoInternacional);

        assertEquals(231_999.2, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Produto - Café Internacional")
      void cenario2() throws ReflectiveOperationException {
        Object produtoInternacional = ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia");

        Class<?> clazz = Produto.class;

        Method metodoCalcularPrecoUnitario = clazz.getDeclaredMethod(ProdutoNacionalUtils.METODO_CALCULAR_PRECO_TOTAL);

        Object resultado = metodoCalcularPrecoUnitario.invoke(produtoInternacional);

        assertEquals(9_596.8, (Double) resultado, 0.1);
      }
    }
  }

  @Nested
  @DisplayName("3.3 Carrinho")
  public class CarrinhoTests {

    @Nested
    @DisplayName("3.3.1 adicionarProduto")
    public class MetodoAdicionarProduto {

      @Test
      @DisplayName("Cenário 1: Adicionando 1 produto")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoAdicionarProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getArgs());

        Object produtoInternacional = ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia");

        metodoAdicionarProduto.invoke(carrinho, produtoInternacional);

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<?> produtos = (List<?>) campoProdutos.get(carrinho);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals(1, produtos.size());
        assertEquals("8888777766665", campoCodigo.get(produtos.get(0)));
        assertEquals("Café Blend", campoNome.get(produtos.get(0)));
      }

      @Test
      @DisplayName("Cenário 2: Adicionando 2 produtos")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoAdicionarProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getArgs());

        Object produto1 = ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA");

        Object produto2 = ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia");

        metodoAdicionarProduto.invoke(carrinho, produto1);
        metodoAdicionarProduto.invoke(carrinho, produto2);

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<?> produtos = (List<?>) campoProdutos.get(carrinho);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals(2, produtos.size());
        assertEquals("1234567890123", campoCodigo.get(produtos.get(0)));
        assertEquals("Computador", campoNome.get(produtos.get(0)));
        assertEquals("8888777766665", campoCodigo.get(produtos.get(1)));
        assertEquals("Café Blend", campoNome.get(produtos.get(1)));
      }

      @Test
      @DisplayName("Cenário 3: Adicionando produto já existente")
      void cenario3() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoAdicionarProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();
        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        campoProdutos.set(carrinho, lista);

        Object produto1 = ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA");

        metodoAdicionarProduto.invoke(carrinho, produto1);

        List<?> produtos = (List<?>) campoProdutos.get(carrinho);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals(1, produtos.size());
        assertEquals("1234567890123", campoCodigo.get(produtos.get(0)));
        assertEquals("Café Blend", campoNome.get(produtos.get(0)));
      }
    }

    @Nested
    @DisplayName("3.3.2 removerProduto")
    public class MetodoRemoverProduto {

      @Test
      @DisplayName("Cenário 1: Removendo 1 produto")
      void cenario1() throws ReflectiveOperationException {
        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoRemoverProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_REMOVER_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_REMOVER_PRODUTO.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        metodoRemoverProduto.invoke(carrinho, 0);

        List<?> produtos = (List<?>) campoProdutos.get(carrinho);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals(1, produtos.size());
        assertEquals("1234567890123", campoCodigo.get(produtos.get(0)));
        assertEquals("Computador", campoNome.get(produtos.get(0)));
      }

      @Test
      @DisplayName("Cenário 2: Removendo índice inválido")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoRemoverProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_REMOVER_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_REMOVER_PRODUTO.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        assertDoesNotThrow(() -> metodoRemoverProduto.invoke(carrinho, 5));

        List<?> produtos = (List<?>) campoProdutos.get(carrinho);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals(2, produtos.size());
        assertEquals("8888777766665", campoCodigo.get(produtos.get(0)));
        assertEquals("Café Blend", campoNome.get(produtos.get(0)));
        assertEquals("1234567890123", campoCodigo.get(produtos.get(1)));
        assertEquals("Computador", campoNome.get(produtos.get(1)));
      }
    }

    @Nested
    @DisplayName("3.3.3 obterProduto")
    public class MetodoObterProduto {

      @Test
      @DisplayName("Cenário 1: Obtendo produto com índice válido")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoObterProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_OBTER_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_OBTER_PRODUTO.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoObterProduto.invoke(carrinho, 1);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        assertEquals("1234567890123", campoCodigo.get(resultado));
        assertEquals("Computador", campoNome.get(resultado));
      }

      @Test
      @DisplayName("Cenário 2: Removendo produto com índice inválido")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoObterProduto = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_OBTER_PRODUTO.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_OBTER_PRODUTO.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoObterProduto.invoke(carrinho, 6);
        assertNull(resultado);
      }
    }

    @Nested
    @DisplayName("3.3.4 buscarPorCategoria")
    public class MetodoBuscarPorCategoria {

      @Test
      @DisplayName("Cenário 1: Buscando categoria existente com produtos")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorCategoria = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarPorCategoria.invoke(carrinho, "Eletrônicos");

        assertEquals(2, resultado.size());
        assertEquals("1234567890123", campoCodigo.get(resultado.get(0)));
        assertEquals("Computador", campoNome.get(resultado.get(0)));
        assertEquals("9999888877776", campoCodigo.get(resultado.get(1)));
        assertEquals("Fone de Ouvido", campoNome.get(resultado.get(1)));
      }

      @Test
      @DisplayName("Cenário 2: Buscando categoria existente com produtos ignorando maiúsculas e minúsculas")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorCategoria = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarPorCategoria.invoke(carrinho, "ELETRônicoS");

        assertEquals(2, resultado.size());
        assertEquals("1234567890123", campoCodigo.get(resultado.get(0)));
        assertEquals("Computador", campoNome.get(resultado.get(0)));
        assertEquals("9999888877776", campoCodigo.get(resultado.get(1)));
        assertEquals("Fone de Ouvido", campoNome.get(resultado.get(1)));
      }

      @Test
      @DisplayName("Cenário 3: Buscando categoria inexistente")
      void cenario3() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorCategoria = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarPorCategoria.invoke(carrinho, "Roupas");

        assertEquals(0, resultado.size());
      }
    }

    @Nested
    @DisplayName("3.3.5 buscarProdutosInternacionais")
    public class MetodoBuscarProdutosInternacionais {

      @Test
      @DisplayName("Cenário 1: Buscando produtos internacionais")
      void cenario1() throws ReflectiveOperationException {
        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarProdutosInternacionais = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_INTERNACIONAIS.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarProdutosInternacionais.invoke(carrinho);

        assertEquals(2, resultado.size());
        assertEquals("1234567890123", campoCodigo.get(resultado.get(0)));
        assertEquals("Computador", campoNome.get(resultado.get(0)));
        assertEquals("8888777766665", campoCodigo.get(resultado.get(1)));
        assertEquals("Café Blend", campoNome.get(resultado.get(1)));
      }

      @Test
      @DisplayName("Cenário 2: Buscando produtos internacionais com lista vazia")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarProdutosInternacionais = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_INTERNACIONAIS.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();
        campoProdutos.set(carrinho, lista);

        List<?> resultado = (List<?>) metodoBuscarProdutosInternacionais.invoke(carrinho);

        assertEquals(0, resultado.size());
      }
    }

    @Nested
    @DisplayName("3.3.6 buscarProdutosNacionais")
    public class MetodoBuscarProdutosNacionais {

      @Test
      @DisplayName("Cenário 1: Buscando produtos nacionais")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarProdutosNacionais = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_NACIONAIS.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarProdutosNacionais.invoke(carrinho);

        assertEquals(1, resultado.size());
        assertEquals("9999888877776", campoCodigo.get(resultado.get(0)));
        assertEquals("Fone de Ouvido", campoNome.get(resultado.get(0)));
      }

      @Test
      @DisplayName("Cenário 2: Buscando produtos nacionais com lista vazia")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarProdutosNacionais = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_NACIONAIS.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();
        campoProdutos.set(carrinho, lista);

        List<?> resultado = (List<?>) metodoBuscarProdutosNacionais.invoke(carrinho);

        assertEquals(0, resultado.size());
      }
    }

    @Nested
    @DisplayName("3.3.7 calcularTotalEmEstoque")
    public class MetodoCalcularTotalEmEstoque {

      @Test
      @DisplayName("Cenário 1: Calculando total estoque com produtos cadastrados")
      void cenario1() throws ReflectiveOperationException {
        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoTotalEstoque = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoTotalEstoque.invoke(carrinho);

        assertEquals(249_395.4, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Calculando total estoque sem produtos cadastrados")
      void cenario2() throws ReflectiveOperationException {
        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoTotalEstoque = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE.getNome());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();
        campoProdutos.set(carrinho, lista);

        Object resultado = metodoTotalEstoque.invoke(carrinho);

        assertEquals(0.0, (Double) resultado);
      }
    }

    @Nested
    @DisplayName("3.3.8 calcularTotalEmEstoquePorCategoria")
    public class MetodoCalcularTotalEmEstoquePorCategoria {

      @Test
      @DisplayName("Cenário 1: Calculando total em estoque de uma categoria válida")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoTotalEstoque = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoTotalEstoque.invoke(carrinho, "Eletrônicos");

        assertEquals(239_798.6, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 2: Calculando total em estoque de uma categoria válida ignorando maiúsculas e minúsculas")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoTotalEstoque = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoTotalEstoque.invoke(carrinho, "eLETRÔNICOS");

        assertEquals(239_798.6, (Double) resultado, 0.1);
      }

      @Test
      @DisplayName("Cenário 3: Calculando total em estoque de uma categoria inválida")
      void cenario3() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoTotalEstoque = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoTotalEstoque.invoke(carrinho, "Roupas");

        assertEquals(0.0, (Double) resultado);
      }
    }

    @Nested
    @DisplayName("3.3.9 buscarPorPaisOrigem")
    public class MetodoBuscarPorPaisOrigem {

      @Test
      @DisplayName("Cenário 1: Buscando produtos com paisOrigem válido")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorPaisOrigem = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "6666555544443", "Camiseta Estampada", "Camiseta confortável com estampa exclusiva",
            "Roupas", 19.99, 80, "Colombia"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarPorPaisOrigem.invoke(carrinho, "Colombia");

        assertEquals(2, resultado.size());
        assertEquals("8888777766665", campoCodigo.get(resultado.get(0)));
        assertEquals("Café Blend", campoNome.get(resultado.get(0)));
        assertEquals("6666555544443", campoCodigo.get(resultado.get(1)));
        assertEquals("Camiseta Estampada", campoNome.get(resultado.get(1)));
      }

      @Test
      @DisplayName("Cenário 2: Buscando produtos com paisOrigem válido, ignorando maiúsculas e minúsculas")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorPaisOrigem = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "6666555544443", "Camiseta Estampada", "Camiseta confortável com estampa exclusiva",
            "Roupas", 19.99, 80, "Colombia"));

        campoProdutos.set(carrinho, lista);

        Class<?> produtoClass = Produto.class;
        Field campoCodigo = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_CODIGO_BARRA);
        Field campoNome = produtoClass.getDeclaredField(ProdutoUtils.ATRIBUTO_NOME);

        campoCodigo.trySetAccessible();
        campoNome.trySetAccessible();

        List<?> resultado = (List<?>) metodoBuscarPorPaisOrigem.invoke(carrinho, "ColoMBIA");

        assertEquals(2, resultado.size());
        assertEquals("8888777766665", campoCodigo.get(resultado.get(0)));
        assertEquals("Café Blend", campoNome.get(resultado.get(0)));
        assertEquals("6666555544443", campoCodigo.get(resultado.get(1)));
        assertEquals("Camiseta Estampada", campoNome.get(resultado.get(1)));
      }

      @Test
      @DisplayName("Cenário 3: Buscando produtos com paisOrigem inválido")
      void cenario3() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoBuscarPorPaisOrigem = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "6666555544443", "Camiseta Estampada", "Camiseta confortável com estampa exclusiva",
            "Roupas", 19.99, 80, "Colombia"));

        campoProdutos.set(carrinho, lista);

        List<?> resultado = (List<?>) metodoBuscarPorPaisOrigem.invoke(carrinho, "Brasil");

        assertEquals(0, resultado.size());
      }
    }

    @Nested
    @DisplayName("3.3.10 existeProdutoPorCodigoBarra")
    public class MetodoExisteProdutoPorCodigoBarra {

      @Test
      @DisplayName("Cenário 1: Buscando produto com código de barra válido")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoExistsPorCodigoDeBarra = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoExistsPorCodigoDeBarra.invoke(carrinho, "1234567890123");

        assertTrue((Boolean) resultado);
      }

      @Test
      @DisplayName("Cenário 2: Buscando produto com código de barra inválido")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoExistsPorCodigoDeBarra = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        campoProdutos.set(carrinho, lista);

        Object resultado = metodoExistsPorCodigoDeBarra.invoke(carrinho, "12345673390123");

        assertFalse((Boolean) resultado);
      }
    }

    @Nested
    @DisplayName("3.3.11 existePorIndice")
    public class MetodoExistePorIndice {

      @Test
      @DisplayName("Cenário 1: Buscando produto com índice válido")
      void cenario1() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoExisteProdutoPorIndice = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "6666555544443", "Camiseta Estampada", "Camiseta confortável com estampa exclusiva",
            "Roupas", 19.99, 80, "Colombia"));

        campoProdutos.set(carrinho, lista);

        assertTrue((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 0));
        assertTrue((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 1));
        assertTrue((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 2));
        assertTrue((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 3));
      }

      @Test
      @DisplayName("Cenário 2: Buscando produto com índice inválido")
      void cenario2() throws ReflectiveOperationException {

        Class<?> carrinhoClass = Carrinho.class;

        Object carrinho = CarrinhoFactory.getInstance();

        Method metodoExisteProdutoPorIndice = carrinhoClass.getDeclaredMethod(
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE.getNome(),
            CarrinhoUtils.IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE.getArgs());

        Field campoProdutos = carrinhoClass.getDeclaredField(CarrinhoUtils.ATRIBUTO_PRODUTO);
        campoProdutos.trySetAccessible();

        List<Object> lista = new ArrayList<>();

        lista.add(ProdutoInternacionalFactory.getInstance(
            "1234567890123", "Computador", "Um computador avançado com recursos inovadores",
            "Eletrônicos", 2899.99, 50, "EUA"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "8888777766665", "Café Blend", "Blend exclusivo de grãos de café, torrado e moído",
            "Alimentos", 29.99, 200, "Colombia"));

        lista.add(ProdutoNacionalFactory.getInstance(
            "9999888877776", "Fone de Ouvido", "Fone de ouvido sem fio com cancelamento de ruído",
            "Eletrônicos", 129.99, 60, "SP"));

        lista.add(ProdutoInternacionalFactory.getInstance(
            "6666555544443", "Camiseta Estampada", "Camiseta confortável com estampa exclusiva",
            "Roupas", 19.99, 80, "Colombia"));

        campoProdutos.set(carrinho, lista);

        assertFalse((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, -1));
        assertFalse((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 4));
        assertFalse((Boolean) metodoExisteProdutoPorIndice.invoke(carrinho, 9));
      }
    }
  }
}
