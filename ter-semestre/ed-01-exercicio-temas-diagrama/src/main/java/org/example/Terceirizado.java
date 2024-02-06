package org.example;

public class Terceirizado {
    private String nome;
    private int cpf;
    private Empresa empresa;
    private double valor;

    public Terceirizado(String nome, int cpf, Empresa empresa, double valor) {
        this.nome = nome;
        this.cpf = cpf;
        this.empresa = empresa;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
