package org.example;

public class TrabalhadorAssalariado extends Trabalhador{
    private double valorHoraExtra;
    private int qtdHoraExtra;

    public TrabalhadorAssalariado(String cpf, String nome, double salario, double valorHoraExtra, int qtdHoraExtra) {
        super(cpf, nome, salario);
        this.valorHoraExtra = valorHoraExtra;
        this.qtdHoraExtra = qtdHoraExtra;
    }

    @Override
    public double getRenda() {
        return getSalario() + (getValorHoraExtra() * getQtdHoraExtra());
    }

    public double getImposto(){
        return getRenda() * 0.12;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public int getQtdHoraExtra() {
        return qtdHoraExtra;
    }

    public void setQtdHoraExtra(int qtdHoraExtra) {
        this.qtdHoraExtra = qtdHoraExtra;
    }

    @Override
    public String toString() {
        return "TrabalhadorAssalariado{" +
                "valorHoraExtra=" + valorHoraExtra +
                ", qtdHoraExtra=" + qtdHoraExtra +
                ", getImposto=" + getImposto() +
                ", getRenda=" + getRenda() +
                "} " + super.toString();
    }
}
