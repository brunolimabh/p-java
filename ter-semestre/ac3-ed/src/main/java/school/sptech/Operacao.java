package school.sptech;

public class Operacao {

    // Atributos
    private String tipo;            // Tipo da operacao: deletar ou aumentarRecurso
    private Recurso recursoDeletado;    // Recurso deletado, quando a operacao eh deletar
    private String categoria;       // Categoria do recurso quando a operacao eh aumentarRecurso
    private int valorAumentado;     // Valor que foi aumentado quando a operacao eh aumentarRecurso

    // Construtor
    public Operacao(String tipo, Recurso recursoDeletado, String categoria, int valorAumentado) {
        this.tipo = tipo;
        this.recursoDeletado = recursoDeletado;
        this.categoria = categoria;
        this.valorAumentado = valorAumentado;
    }

    // toString()
    @Override
    public String toString() {
        return "Operacao{" +
                "tipo='" + tipo + '\'' +
                ", recursoDeletado=" + recursoDeletado +
                ", categoria='" + categoria + '\'' +
                ", valorAumentado=" + valorAumentado +
                '}';
    }

    // Getters e Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Recurso getRecursoDeletado() {
        return recursoDeletado;
    }

    public void setRecursoDeletado(Recurso recursoDeletado) {
        this.recursoDeletado = recursoDeletado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getValorAumentado() {
        return valorAumentado;
    }

    public void setValorAumentado(int valorAumentado) {
        this.valorAumentado = valorAumentado;
    }
}
