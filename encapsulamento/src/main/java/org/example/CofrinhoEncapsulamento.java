package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CofrinhoEncapsulamento {

    /*
        Modificadores de acesso:
        private
        public
        protected
        default
     */

    /*
        Ordem de estrutura do codigo:
        Atributos
        construtores
        métodos regra de negocio
        getter/setter/toString
     */

    private String meta = "";
    private Scanner inputNumber = new Scanner(System.in);
    private Double valorCofrinho;
    private Boolean isQuebrado;

    // Contrutores
    // PascalCase = pois carrega o nome da classe
    public CofrinhoEncapsulamento() {
        this.valorCofrinho = 0.0;
        isQuebrado = false;
    }

    void cofrinhoDepositar() {
        System.out.println("Qual valor você deseja guardar?");
        Double valor = inputNumber.nextDouble();
        valorCofrinho += valor;
        System.out.println("Com um depósito de %.2f, o seu cofrinho está com R$%.2f".formatted(valor, valorCofrinho));
    }

    void cofrinhoAgitar() {
        Double aleatorio = ThreadLocalRandom.current().nextDouble(valorCofrinho);
        valorCofrinho -= aleatorio;
        System.out.println("Você agitou o cofrinho e conseguiu R$%.2f, agora você está com um saldo de R$%.2f no cofrinho"
                .formatted(aleatorio, valorCofrinho));
    }

    void transf(CofrinhoEncapsulamento x){

        this.valorCofrinho += x.valorCofrinho;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String x) {
        meta = x;
    }
}