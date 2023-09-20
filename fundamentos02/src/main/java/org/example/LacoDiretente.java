package org.example;

import java.util.ArrayList;
import java.util.List;

public class LacoDiretente {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Diego");
        nomes.add("Manoel");
        nomes.add("Caio");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("-".repeat(15));

        // For aprimorado / foreach
        for (String nomeDaVez: nomes) {
            System.out.println(nomeDaVez);
        }

        System.out.println("-".repeat(15));

        nomes.forEach(nome -> System.out.println(nome));
    }
}
