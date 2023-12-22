package org.example.model;

public abstract class Componente {
    private Integer idComp;
    private String nome;
    private String unidadeMedida;

    public Componente(Integer idComp, String nome, String unidadeMedida) {
        this.idComp = idComp;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
    }

    public abstract Double porcentagemUso();

    public Integer getIdComp() {
        return idComp;
    }

    public void setIdComp(Integer idComp) {
        this.idComp = idComp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "idComp=" + idComp +
                ", nome='" + nome + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                '}';
    }
}
