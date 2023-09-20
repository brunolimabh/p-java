package school.sptech;

import java.util.Scanner;

public class CalculoRenda {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem-vindo ao Bolsa Filhos...");
        System.out.println("Digite os filhos de 0-3: ");
        Integer filhos1 = leitor.nextInt();
        System.out.println("Agora, filhos de 4-16: ");
        Integer filhos2 = leitor.nextInt();
        System.out.println("Por último, filhos de 17-18: ");
        Integer filhos3 = leitor.nextInt();

        Integer qtdFilhos = filhos1 + filhos2 + filhos3;

        System.out.println("Calculando sua bolsa...");

        Double valor1 = filhos1 * 25.12 ;
        Double valor2 = filhos2 * 15.88;
        Double valor3 = filhos3 * 12.44;
        Double qtdBolsa = valor1 + valor2 + valor3;

        System.out.println(
                "Você tem um total de " + qtdFilhos +
                " filhos e vai receber R$" + qtdBolsa+
                " de bolsa!");
    }
}
