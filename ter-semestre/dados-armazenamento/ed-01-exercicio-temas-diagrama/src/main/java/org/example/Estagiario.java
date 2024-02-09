package org.example;

import java.time.LocalDate;

public class Estagiario extends Funcionario{
    private LocalDate dataContrato;

    public Estagiario(String nome, int cpf, double salario, LocalDate dataContrato) {
        super(nome, cpf, salario);
        this.dataContrato = dataContrato;
    }

    @Override
    public double getValorPagamento() {
        return getSalario();
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }
}
