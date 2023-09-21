package org.example;

public class Livro {
    private String codigo;
    private String nome;
    private String autor;
    private Integer qtdPaginas;

    public Livro(String codigo, String nome, String autor, Integer qtdPaginas) {
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.qtdPaginas = qtdPaginas;
    }

    public Double calcularPeso() {
        Double peso = getQtdPaginas() * 2.4;
        return peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", qtdPaginas=" + qtdPaginas +
                '}';
    }
}
