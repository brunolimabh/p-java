package org.example;

public class Operacao {

    private ContaBancaria objConta;
    private String tipoOperacao;
    private Double valor;

    public Operacao(ContaBancaria objConta, String tipoOperacao, Double valor) {
        this.objConta = objConta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public ContaBancaria getObjConta() {
        return objConta;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "objConta=" + objConta +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
