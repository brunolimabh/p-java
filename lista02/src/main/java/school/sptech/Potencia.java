package school.sptech;

import java.util.Scanner;

public class Potencia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Exercício 05 - Potência\n");

        System.out.println("Digite o valor base: ");
        Integer base = input.nextInt();
        System.out.println("Digite o valor do expoente: ");
        Integer expoente = input.nextInt();
        Double resultado = Math.pow(base,expoente);
        System.out.println("O valor " + base +
                            " elevado a " + expoente +
                            " é igual a " + Math.round(resultado));
    }
}
