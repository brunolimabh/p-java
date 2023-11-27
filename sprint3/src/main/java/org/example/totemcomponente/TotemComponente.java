package org.example.totemcomponente;

public class TotemComponente {
    private String nome;
    private Integer fkTotem;
    private Integer valor;

    public TotemComponente() {
    }

    public TotemComponente(String nome, Integer fkTotem, Integer valor) {
        this.nome = nome;
        this.fkTotem = fkTotem;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkTotem() {
        return fkTotem;
    }

    public void setFkTotem(Integer fkTotem) {
        this.fkTotem = fkTotem;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "TotemComponente{" +
                "nome=" + nome +
                ", fkTotem=" + fkTotem +
                ", valor=" + valor +
                '}';
    }
}
