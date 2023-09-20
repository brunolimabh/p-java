package school.sptech;

import java.util.Scanner;

public class CalculoTroco {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Exercicio 03 - Cálculo de Troco\n");

        System.out.println("Valor unitário do produto: ");
        Double valorProduto = leitor.nextDouble();
        System.out.println("Quantidade vendida: ");
        Integer qtdVendida = leitor.nextInt();
        System.out.println("Valor pago pelo cliente: ");
        Double valorPago = leitor.nextDouble();

        Double troco = valorPago - (valorProduto * qtdVendida);

        System.out.println("Seu troco será de R$" + troco);
    }
}

