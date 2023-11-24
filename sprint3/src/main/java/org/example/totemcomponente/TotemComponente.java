package org.example.totemcomponente;

public class TotemComponente {
    private Integer fkComponente;
    private Integer fkTotem;
    private Integer valor;

    public TotemComponente() {
    }

    public TotemComponente(Integer fkComponente, Integer fkTotem, Integer valor) {
        this.fkComponente = fkComponente;
        this.fkTotem = fkTotem;
        this.valor = valor;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
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
                "fkComponente=" + fkComponente +
                ", fkTotem=" + fkTotem +
                ", valor=" + valor +
                '}';
    }
}
