package school.sptech;

import java.util.Scanner;

public class CalculoMedia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Exercício 04 - Cálculo de Média\n");

        System.out.println("Olá, informe o seu nome: ");
        String nome = leitor.nextLine();
        System.out.println("Digite a primeira nota: ");
        Double num1 = leitor.nextDouble();
        System.out.println("Agora, a segunda nota: ");
        Double num2 = leitor.nextDouble();

        Double media = (num1 + num2) / 2;

        System.out.println("Olá, " + nome + "! Sua média foi de " + media);

    }
}
