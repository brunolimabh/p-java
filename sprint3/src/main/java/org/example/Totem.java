package org.example;

public class Totem {
    private Integer idTotem;
    private String nome;
    private Integer fkAeroporto;
    private Integer fkEmpresa;

    public Totem(Integer idTotem, String nome, Integer fkAeroporto, Integer fkEmpresa) {
        this.idTotem = idTotem;
        this.nome = nome;
        this.fkAeroporto = fkAeroporto;
        this.fkEmpresa = fkEmpresa;
    }
}
