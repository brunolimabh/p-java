package org.example.model;

public class TotemComponente {
    private Integer fkComponente;
    private Integer fkTotem;
    private Integer valor;
    private Integer alerta;
    private Integer critico;

    public TotemComponente() {
    }

    public TotemComponente(Integer fkComponente, Integer fkTotem, Integer valor, Integer alerta, Integer critico) {
        this.fkComponente = fkComponente;
        this.fkTotem = fkTotem;
        this.valor = valor;
        this.alerta = alerta;
        this.critico = critico;
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

    public Integer getAlerta() {
        return alerta;
    }

    public void setAlerta(Integer alerta) {
        this.alerta = alerta;
    }

    public Integer getCritico() {
        return critico;
    }

    public void setCritico(Integer critico) {
        this.critico = critico;
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
