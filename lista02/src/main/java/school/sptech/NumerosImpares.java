package school.sptech;

public class NumerosImpares {
    public static void main(String[] args) {
        System.out.println("Exercício 03 - Números Ímpares\n");

        for (Integer i = 0; i <= 90; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
