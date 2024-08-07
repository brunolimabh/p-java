package school.sptech;

public class Recurso {

    // Atributos
    private int id;             // ID do recurso
    private String nome;        // Nome do recurso
    private String categoria;   // Categoria do recurso
    private int quantidade;     // Quantidade do recurso

    // Construtor

    public Recurso(int id, String nome, String categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    // toString()

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

