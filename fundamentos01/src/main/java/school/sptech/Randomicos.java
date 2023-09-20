package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Randomicos {
    public static void main(String[] args) {

        Integer aleatorio = ThreadLocalRandom.current().nextInt(5, 11);
        System.out.println(aleatorio);

        Double aleatorioReal = ThreadLocalRandom.current().nextDouble(0,10.1);
        System.out.printf("%.2f", aleatorioReal);
    }
}
