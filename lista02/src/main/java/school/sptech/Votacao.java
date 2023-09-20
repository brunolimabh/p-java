package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Votacao {
    public static void main(String[] args) {
        System.out.println("Exercício 09 - Votacao\n");

        System.out.println("Sorteando 10 votos para a pizza...\n");
        Integer mussarela = 0;
        Integer calabresa = 0;
        Integer quatroQueijos = 0;
        for (Integer i = 1; i <= 10; i++) {
            Integer aleatorio = ThreadLocalRandom.current().nextInt(1,4);

            switch (aleatorio) {
                case 1:
                    mussarela++;
                    break;
                case 2:
                    calabresa++;
                    break;
                case 3:
                    quatroQueijos++;
                    break;
            }
        }
        System.out.println("Mussarela:" + mussarela);
        System.out.println("Calabresa:" + calabresa);
        System.out.println("Quatro Queijos:" + quatroQueijos);

        String maisVotada = "";
        if (mussarela > calabresa && mussarela > quatroQueijos) {
            maisVotada = "Mussarela";
        } else if (calabresa > mussarela && calabresa > quatroQueijos) {
            maisVotada = "Calabresa";
        } else if (quatroQueijos > mussarela && quatroQueijos > calabresa) {
            maisVotada = "Quatro Queijos";
        } else if (mussarela == calabresa) {
            maisVotada = "Mussarela e Calabresa";
        } else if (quatroQueijos == calabresa) {
            maisVotada = "Quatro Queijo e Calabresa";
        } else if (mussarela == quatroQueijos) {
            maisVotada = "Mussarela e Quatro Queijo";
        }

        System.out.println("\nA pizza favorita foi: " + maisVotada);


    }
}
