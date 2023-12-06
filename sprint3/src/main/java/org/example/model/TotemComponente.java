package org.example.model;

public class TotemComponente {
    private Integer fkComponente;
    private Integer fkTotem;
    private Integer valor;

    public TotemComponente() {
    }

    public TotemComponente(Integer nome, Integer fkTotem, Integer valor) {
        this.fkComponente = nome;
        this.fkTotem = fkTotem;
        this.valor = valor;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer nome) {
        this.fkComponente = nome;
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
                "nome=" + fkComponente +
                ", fkTotem=" + fkTotem +
                ", valor=" + valor +
                '}';
    }
}
