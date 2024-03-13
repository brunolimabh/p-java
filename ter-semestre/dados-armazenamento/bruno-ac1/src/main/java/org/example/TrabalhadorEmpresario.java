package org.example;

public class TrabalhadorEmpresario extends Trabalhador {
    private double valorParticipacaoLucro;

    public TrabalhadorEmpresario(String cpf, String nome, double salario, double valorParticipacaoLucro) {
        super(cpf, nome, salario);
        this.valorParticipacaoLucro = valorParticipacaoLucro;
    }

    public double getRenda(){
        return getSalario() + getValorParticipacaoLucro();
    }

    public double getImposto(){
        return getRenda() * 0.25;
    }

    public double getValorParticipacaoLucro() {
        return valorParticipacaoLucro;
    }

    public void setValorParticipacaoLucro(double valorParticipacaoLucro) {
        this.valorParticipacaoLucro = valorParticipacaoLucro;
    }

    @Override
    public String toString() {
        return "TrabalhadorEmpresario{" +
                "valorParticipacaoLucro=" + valorParticipacaoLucro +
                "getImposto=" + getImposto() +
                "getRenda=" + getRenda() +
                "} " + super.toString();
    }
}
