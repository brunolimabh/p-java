package org.example;

import org.w3c.dom.DOMImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private String titular;
    private Double saldo;
    private List<Historico> operacoes;

    public ContaCorrente(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.operacoes = new ArrayList<>();
    }

    public void depositar(Double valor) {
        operacao("Deposito", valor);
        this.saldo+= valor;
    }
    public void sacar(Double valor) {
        operacao("Saque", valor);
        this.saldo-= valor;
    }
    public void exibirExtrato() {
        System.out.println("""
                -----------------
                EXTRATO
                -----------------
                """);
        for (Historico historico: operacoes) {
            LocalDateTime data = historico.getDataHora();
            String operacao = historico.getOperacao();
            Double descricao = historico.getDescricao();
            System.out.println("""
                    Data: %s
                    Operação: %s
                    Valor: %f
                    -----------------
                    """.formatted(data,operacao,descricao));
        }
    }

    public Historico operacao(String operacao, Double descricao) {
        Historico historico = new Historico(operacao, descricao);
        operacoes.add(historico);
        return historico;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", operacoes=" + operacoes +
                '}';
    }
}
