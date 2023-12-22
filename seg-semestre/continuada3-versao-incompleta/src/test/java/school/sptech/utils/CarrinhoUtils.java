package school.sptech.utils;

import school.sptech.Produto;

import java.util.List;

public class CarrinhoUtils {

    public static final String ATRIBUTO_PRODUTO = "produtos";

    public static List<String> getAtributos() {
        return List.of(ATRIBUTO_PRODUTO);
    }

    public static List<String> getMetodos() {
        return List.of(
                METODO_ADICIONAR_PRODUTO,
                METODO_REMOVER_PRODUTO,
                METODO_OBTER_PRODUTO,
                METODO_BUSCAR_POR_CATEGORIA,
                METODO_BUSCAR_PRODUTOS_INTERNACIONAIS,
                METODO_BUSCAR_PRODUTOS_NACIONAIS,
                METODO_BUSCAR_POR_PAIS_ORIGEM,
                METODO_CALCULAR_TOTAL_ESTOQUE,
                METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA,
                METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA,
                METODO_EXISTE_PRODUTO_POR_INDICE
        );
    }

    public static final String METODO_ADICIONAR_PRODUTO = "adicionarProduto";
    public static final String METODO_REMOVER_PRODUTO = "removerProduto";
    public static final String METODO_OBTER_PRODUTO = "obterProduto";
    public static final String METODO_BUSCAR_POR_CATEGORIA = "buscarPorCategoria";
    public static final String METODO_BUSCAR_PRODUTOS_INTERNACIONAIS = "buscarProdutosInternacionais";
    public static final String METODO_BUSCAR_PRODUTOS_NACIONAIS = "buscarProdutosNacionais";
    public static final String METODO_BUSCAR_POR_PAIS_ORIGEM = "buscarPorPaisOrigem";
    public static final String METODO_CALCULAR_TOTAL_ESTOQUE = "calcularTotalEmEstoque";
    public static final String METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA = "calcularTotalEmEstoquePorCategoria";
    public static final String METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA = "existeProdutoPorCodigoBarra";
    public static final String METODO_EXISTE_PRODUTO_POR_INDICE = "existePorIndice";

    //IMPL
    public static final Metodo IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO = new Metodo("adicionarProduto", new Class<?>[]{Produto.class});
    public static final Metodo IMPLEMENTACAO_METODO_REMOVER_PRODUTO = new Metodo("removerProduto", new Class<?>[]{int.class});
    public static final Metodo IMPLEMENTACAO_METODO_OBTER_PRODUTO = new Metodo("obterProduto", new Class<?>[]{int.class});
    public static final Metodo IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA = new Metodo("buscarPorCategoria", new Class<?>[]{String.class});
    public static final Metodo IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_INTERNACIONAIS = new Metodo("buscarProdutosInternacionais", null);
    public static final Metodo IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_NACIONAIS = new Metodo("buscarProdutosNacionais", null);
    public static final Metodo IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM = new Metodo("buscarPorPaisOrigem", new Class<?>[]{String.class});
    public static final Metodo IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE = new Metodo("calcularTotalEmEstoque", null);
    public static final Metodo IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA = new Metodo("calcularTotalEmEstoquePorCategoria", new Class<?>[]{String.class});
    public static final Metodo IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA = new Metodo("existeProdutoPorCodigoBarra", new Class<?>[]{String.class});
    public static final Metodo IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE = new Metodo("existePorIndice", new Class<?>[]{int.class});

    public static List<Metodo> getMetodoImplementacoes() {
        return List.of(
                IMPLEMENTACAO_METODO_ADICIONAR_PRODUTO,
                IMPLEMENTACAO_METODO_REMOVER_PRODUTO,
                IMPLEMENTACAO_METODO_OBTER_PRODUTO,
                IMPLEMENTACAO_METODO_BUSCAR_POR_CATEGORIA,
                IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_INTERNACIONAIS,
                IMPLEMENTACAO_METODO_BUSCAR_PRODUTOS_NACIONAIS,
                IMPLEMENTACAO_METODO_BUSCAR_POR_PAIS_ORIGEM,
                IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE,
                IMPLEMENTACAO_METODO_CALCULAR_TOTAL_ESTOQUE_POR_CATEGORIA,
                IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_CODIGO_BARRA,
                IMPLEMENTACAO_METODO_EXISTE_PRODUTO_POR_INDICE
        );
    }
}
