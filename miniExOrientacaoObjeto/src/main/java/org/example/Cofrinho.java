package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Cofrinho {

    Scanner inputNumber = new Scanner(System.in);
    Double valorCofrinho = 0.0;
    Boolean isQuebrado = false;

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
}
