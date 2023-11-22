package school.sptech.utils;

import java.util.List;

public class ProdutoUtils {

    public static final String ATRIBUTO_CODIGO_BARRA = "codigoBarra";
    public static final String ATRIBUTO_NOME = "nome";
    public static final String ATRIBUTO_DESCRICAO = "descricao";
    public static final String ATRIBUTO_CATEGORIA = "categoria";
    public static final String ATRIBUTO_PRECO = "preco";
    public static final String ATRIBUTO_QUANTIDADE = "quantidade";
    public static final String METODO_CALCULAR_PRECO_UNITARIO = "calcularPrecoUnitario";
    public static final String METODO_CALCULAR_PRECO_TOTAL = "calcularPrecoTotal";

    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_UNITARIO = new Metodo("calcularPrecoUnitario", null);

    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_TOTAL = new Metodo("calcularPrecoTotal", null);

    public static List<String> getAtributos() {
        return List.of(ATRIBUTO_CODIGO_BARRA, ATRIBUTO_NOME, ATRIBUTO_DESCRICAO, ATRIBUTO_CATEGORIA, ATRIBUTO_PRECO, ATRIBUTO_QUANTIDADE);
    }

    public static List<String> getMetodos() {
        return List.of(METODO_CALCULAR_PRECO_UNITARIO, METODO_CALCULAR_PRECO_TOTAL);
    }
}
