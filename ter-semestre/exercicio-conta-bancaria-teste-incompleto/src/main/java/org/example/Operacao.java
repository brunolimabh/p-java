package org.example;
public class Operacao {

    private ContaBancaria contaBancaria;
    private String tipoOperacao;
    private Double valor;

    public Operacao(ContaBancaria contaBancaria, String tipoOperacao, Double valor) {
        this.contaBancaria = contaBancaria;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("\n----------Operação----------\n" +
                        "Tipo de operação: %s\n" +
                        "Valor da operação: R$%.2f",
                tipoOperacao, valor);
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

}
