package school.sptech;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Sorteio {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Boolean isSorteado = true;
        Integer impares = 0;
        Integer pares = 0;
        Integer num;
        System.out.println("Exercício 06 - Sorteio\n");

        do {
            System.out.println("Escolha um número entre 1-100: ");
            num = leitor.nextInt();
        } while (num < 1 || num > 100);

        for (Integer i = 1; i <= 200; i++) {
            Integer aleatorio = ThreadLocalRandom.current().nextInt( 1,101);

            if (num == aleatorio && isSorteado == true) {
                System.out.println("1° vez sorteado: " + i +"ª posição!\n");
                isSorteado = false;
            }
            if (aleatorio %2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        if (isSorteado == true) {
            System.out.println("O número " + num + " não foi sorteado nenhuma vez!");
        }
        System.out.println("Numeros pares sorteados: " + pares);
        System.out.println("Numeros impares sorteados: " + impares);
    }
}
