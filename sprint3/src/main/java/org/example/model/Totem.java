package org.example.model;

public class Totem {
    private Integer idTotem;
    private String nome;
    private Integer fkAeroporto;
    private Integer fkEmpresa;

    public Totem() {
    }

    public Totem(Integer idTotem, String nome, Integer fkAeroporto, Integer fkEmpresa) {
        this.idTotem = idTotem;
        this.nome = nome;
        this.fkAeroporto = fkAeroporto;
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getIdTotem() {
        return idTotem;
    }

    public void setIdTotem(Integer idTotem) {
        this.idTotem = idTotem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFkAeroporto() {
        return fkAeroporto;
    }

    public void setFkAeroporto(Integer fkAeroporto) {
        this.fkAeroporto = fkAeroporto;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}
