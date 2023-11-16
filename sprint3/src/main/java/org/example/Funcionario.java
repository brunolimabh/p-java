package org.example;

public class Funcionario {
    private Integer idFuncionario;
    private String nome;
    private String email ;
    private String senha;
    private Integer fkEmpresa;

    public Funcionario(Integer idFuncionario, String nome, String email, String senha, Integer fkEmpresa) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.fkEmpresa = fkEmpresa;
    }
}
