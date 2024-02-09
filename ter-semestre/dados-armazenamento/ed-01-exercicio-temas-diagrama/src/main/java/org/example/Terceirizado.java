package org.example;

public class Terceirizado extends Pessoa {
    private Empresa empresa;
    private double valor;
    private int horas;

    public Terceirizado(String nome, int cpf, Empresa empresa, double valor, int horas) {
        super(nome, cpf);
        this.empresa = empresa;
        this.valor = valor;
        this.horas = horas;
    }


    @Override
    public double getValorPagamento() {
        return getValor() * getHoras();
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
