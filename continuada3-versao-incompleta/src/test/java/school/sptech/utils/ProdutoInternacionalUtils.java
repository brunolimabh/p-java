package school.sptech.utils;

import java.util.List;

public class ProdutoInternacionalUtils {

    public static final String ATRIBUTO_PAIS_ORIGEM = "paisOrigem";
    public static final String ATRIBUTO_TAXA_IMPORTACAO = "TAXA_IMPORTACAO";

    public static final String METODO_CALCULAR_PRECO_UNITARIO = "calcularPrecoUnitario";
    public static final String METODO_CALCULAR_PRECO_TOTAL = "calcularPrecoTotal";
    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_UNITARIO = new Metodo("calcularPrecoUnitario", null);
    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_TOTAL = new Metodo("calcularPrecoTotal", null);

    public static List<String> getAtributos() {
        return List.of(ATRIBUTO_PAIS_ORIGEM);
    }
}
