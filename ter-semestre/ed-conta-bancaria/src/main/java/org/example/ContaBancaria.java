package org.example;

public class ContaBancaria {

    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public boolean debitar(Double valor) {
        if (valor == null) throw new IllegalArgumentException();
        if (saldo == 0) {
            System.out.println("Saldo insuficiente");
            return false;
        }

        saldo = saldo - valor;
        System.out.println("Saldo: " + saldo);
        return true;
    }

    public void creditar(Double valor) {
        saldo = saldo + valor;
        System.out.println("Saldo: " + saldo);
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
