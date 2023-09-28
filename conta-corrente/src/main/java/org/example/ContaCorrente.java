package org.example;

import org.w3c.dom.DOMImplementation;

public class ContaCorrente {

    private String titular;
    private Double saldo;

    public ContaCorrente(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(Double valor) {
        this.saldo+= valor;
    }
    public void sacar(Double valor) {
        this.saldo-= valor;
    }
    public void exibirExtrato() {

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
}
