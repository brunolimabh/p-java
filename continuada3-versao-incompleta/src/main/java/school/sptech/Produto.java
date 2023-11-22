package school.sptech;

public abstract class Produto {
    private String codigoBarra;
    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;
    private int quantidade;

    public Produto(String codigoBarra, String nome, String descricao, String categoria, Double preco, int quantidade) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public abstract Double calcularPrecoUnitario();
    public abstract Double calcularPrecoTotal();

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
