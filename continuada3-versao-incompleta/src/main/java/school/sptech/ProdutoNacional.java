package school.sptech;

public class ProdutoNacional extends Produto{
    private String estadoOrigem;

    public ProdutoNacional(String codigoBarra, String nome, String descricao, String categoria, Double preco, int quantidade, String estadoOrigem) {
        super(codigoBarra, nome, descricao, categoria, preco, quantidade);
        this.estadoOrigem = estadoOrigem;
    }

    @Override
    public Double calcularPrecoUnitario() {
        return super.getPreco();
    }

    @Override
    public Double calcularPrecoTotal() {
        return super.getPreco() * super.getQuantidade();
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }
}
