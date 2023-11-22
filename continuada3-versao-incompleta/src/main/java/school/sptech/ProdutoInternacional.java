package school.sptech;

public class ProdutoInternacional extends Produto{
    public static final Double TAXA_IMPORTACAO = 1.6;
    private String paisOrigem;

    public ProdutoInternacional(String codigoBarra, String nome, String descricao, String categoria, Double preco, int quantidade, String paisOrigem) {
        super(codigoBarra, nome, descricao, categoria, preco, quantidade);
        this.paisOrigem = paisOrigem;
    }

    @Override
    public Double calcularPrecoUnitario() {
        return super.getPreco() * getTaxaImportacao();
    }

    @Override
    public Double calcularPrecoTotal() {
        return (super.getPreco() * super.getQuantidade()) * getTaxaImportacao();
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public static Double getTaxaImportacao() {
        return TAXA_IMPORTACAO;
    }
}
