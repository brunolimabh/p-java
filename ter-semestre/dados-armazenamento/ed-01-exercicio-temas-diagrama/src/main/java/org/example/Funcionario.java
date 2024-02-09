package org.example;

public abstract class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, int cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
