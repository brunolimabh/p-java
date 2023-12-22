package school.sptech.utils;

import java.util.List;

public class ProdutoNacionalUtils {
    public static final String ATRIBUTO_ESTADO_ORIGEM = "estadoOrigem";
    public static final String METODO_CALCULAR_PRECO_UNITARIO = "calcularPrecoUnitario";
    public static final String METODO_CALCULAR_PRECO_TOTAL = "calcularPrecoTotal";
    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_UNITARIO = new Metodo("calcularPrecoUnitario", null);
    public final Metodo IMPLEMENTACAO_METODO_CALCULAR_PRECO_TOTAL = new Metodo("calcularPrecoTotal", null);

    public static List<String> getAtributos() {
        return List.of(ATRIBUTO_ESTADO_ORIGEM);
    }
}
