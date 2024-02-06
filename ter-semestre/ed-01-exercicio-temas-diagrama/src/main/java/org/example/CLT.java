package org.example;

public class CLT extends Funcionario{
    private double fgts;

    public CLT(String nome, int cpf, double salario, double fgts) {
        super(nome, cpf, salario);
        this.fgts = fgts;
    }

    @Override
    public double getValorPagamento() {
        return getSalario() * this.fgts;
    }

    public double getFgts() {
        return fgts;
    }

    public void setFgts(double fgts) {
        this.fgts = fgts;
    }
}
