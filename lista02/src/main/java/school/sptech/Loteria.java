package school.sptech;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Loteria {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Exercício 01 - Loteria");

        System.out.println("Escolha um número de 0-10: ");
        Integer num = leitor.nextInt();

        Integer aleatorio = -1;
        for (Integer i = 1; num != aleatorio; i++) {
            aleatorio = ThreadLocalRandom.current().nextInt(11);
            System.out.println(i);
            System.out.println(aleatorio);

            if (aleatorio == num) {
                if (i <= 3) {
                    System.out.println("Você é MUITO sortudo");
                } else if (i <= 10) {
                    System.out.println("Você é sortudo");
                } else {
                    System.out.println("É melhor você parar de apostar e ir trabalhar");
                }

            }
        }
    }
}