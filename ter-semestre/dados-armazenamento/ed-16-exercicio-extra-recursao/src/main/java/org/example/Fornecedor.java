package org.example;

public class Fornecedor {
    private double precoA;
    private double precoB;
    private int qtdA;
    private int qtdB;
    private double troco;

    public Fornecedor(double precoA, double precoB) {
        this.precoA = precoA;
        this.precoB = precoB;
    }

    public void vandaRecursivo(double valor){
        if (valor >= precoA) {
            qtdA++;
            valor -= precoA;
            vandaRecursivo(valor);
        } else if (valor >= precoB) {
            qtdB++;
            valor -= precoB;
            vandaRecursivo(valor);
        } else {
            troco = valor;
        }
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "precoA=" + precoA +
                ", precoB=" + precoB +
                ", qtdA=" + qtdA +
                ", qtdB=" + qtdB +
                ", troco=" + troco +
                '}';
    }
}


