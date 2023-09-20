package org.example;

public class ContaCorrente {

    private Double saldo;
    private String nome;

    public ContaCorrente(Double saldo, String nome) {
        this.saldo = saldo;
        this.nome = nome;
    }

    public void depositar(Double valor){
        if (valor > 0.0) {
            System.out.println("""
                ---------------------
                Conta: %s
                ---------------------
                Saldo: R$%.2f
                Depósito: R$%.2f
                
                Novo Saldo: R$%.2f
                ---------------------
                """.formatted(this.nome, this.saldo, valor, (this.saldo+valor)));
            this.saldo += valor;
        } else {
            System.out.println("Insira um valor maior do que 0");
        }
    }
    public Double sacar(Double valor){
        if (valor > 0.0 && valor <= this.saldo) {
            System.out.println("""
                ---------------------
                Conta: %s
                ---------------------
                Saldo: R$%.2f
                Saque: R$%.2f
                
                Novo Saldo: R$%.2f
                ---------------------
                """.formatted(this.nome,this.saldo, valor, (this.saldo-valor)));
            this.saldo -= valor;
        } else {
            System.out.println("Insira um valor maior do que 0 e menor do que o saldo");
        }
        return valor;
    }
    public void transferir(Double valor, ContaCorrente contaDestino ){
        if (valor > 0.0 && valor <= this.saldo) {
            System.out.println("""
                ---------------------
                Conta: %s 
                ---------------------
                Saldo: R$%.2f
                Conta Destinatária: %s
                Valor Tranferido: R$%.2f
                
                Novo Saldo: R$%.2f
                ---------------------
                """.formatted(this.nome, this.saldo, contaDestino.nome, valor, (this.saldo-valor)));
            this.saldo -= valor;
            System.out.println("""
                ---------------------
                Conta: %s
                ---------------------
                Saldo: R$%.2f
                Conta Remetente: %s
                Valor Recebido: R$%.2f
                
                Novo Saldo: R$%.2f
                ---------------------
                """.formatted(contaDestino.nome,contaDestino.saldo, this.nome, valor, (contaDestino.saldo+valor)));
            contaDestino.saldo += valor;

        } else {
            System.out.println("Insira um valor maior do que 0 e menor do que o saldo");
        }
    }

    public Double getSaldo() {
        System.out.println("""
                ---------------------
                Conta: %s
                Saldo Atual: R$%.2f
                ---------------------
                """.formatted(this.nome, this.saldo));
        return saldo;
    }
}
