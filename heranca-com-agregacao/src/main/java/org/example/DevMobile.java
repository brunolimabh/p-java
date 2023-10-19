package org.example;

public class DevMobile extends Dev {
    private Integer qtdHoras;
    private Double valorHora;

    public DevMobile(String nome, Integer qtdHoras, Double valorHora) {
        super(nome, qtdHoras, valorHora);
    }

    @Override
    public Double getSalario() {
        return super.getSalario() + (this.getValorHora()*this.getQtdHoras());
    }

    @Override
    public Integer getQtdHoras() {
        return qtdHoras;
    }

    @Override
    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    @Override
    public Double getValorHora() {
        return valorHora;
    }

    @Override
    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }


}
