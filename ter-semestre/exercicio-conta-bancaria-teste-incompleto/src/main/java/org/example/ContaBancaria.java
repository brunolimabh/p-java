package org.example;
public class ContaBancaria {

    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Boolean debitar(Double valor){
        if (valor == null || valor <= 0) throw new IllegalArgumentException();
        if (saldo - valor <= 0) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        saldo = saldo - valor;
        return true;
    }

    public void creditar(Double valor){
        if (valor == null || valor <= 0) throw new IllegalArgumentException();
        saldo = saldo + valor;
    }


    /* Método toString() - retorna uma String formatada com o número e o saldo da conta. */
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }

    // Getters
    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

}
