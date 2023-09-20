package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
        System.out.println("Exercício 02 - Acumulador\n");

        Integer soma = 0;
        Integer aleatorio = -1;

        for (Integer i = 0; aleatorio != 0; i++) {
            aleatorio = ThreadLocalRandom.current().nextInt(11);
            soma = soma + aleatorio;
            if (aleatorio == 0) {
                System.out.println("A soma dos números é "+soma);
            }
        }
    }
}
