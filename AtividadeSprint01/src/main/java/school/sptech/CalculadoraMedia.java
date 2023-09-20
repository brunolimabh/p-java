package school.sptech;

import java.util.Scanner;

public class CalculadoraMedia {
    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);

        System.out.println("Digite a 1ª nota:");
        Double nota1 = inputNum.nextDouble();
        System.out.println("Digite a 2ª nota:");
        Double nota2 = inputNum.nextDouble();

        Double media = ((nota1*.4) + (nota2*.6));
        System.out.println("Média do aluno: %.2f".formatted(media));

    }
}
