package org.example;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {

        /* NÃO FAZER
        List listaDiferente = new ArrayList();

        listaDiferente.add("Bruno Henroqie");
        listaDiferente.add(30);
        listaDiferente.add(true);
        listaDiferente.add(1.82);
        */

        List<Integer> numInteiros = new ArrayList();
        numInteiros.add(10);
        numInteiros.add(20);
        numInteiros.add(30);
        numInteiros.add(40);
        numInteiros.add(0,32);

        for (int i = 0; i < numInteiros.size(); i++) {
            System.out.println(numInteiros.get(i));
        }

        System.out.println("-".repeat(15));

        // Tomar cuidado
        numInteiros.remove(0);

        System.out.println(numInteiros);

        System.out.println("-".repeat(15));

        List<String> nomes = new ArrayList();
        nomes.add("Manoel");
        nomes.add("Marise");
        nomes.add("Diego");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("-".repeat(15));

        nomes.set(0,"Celia");
        System.out.println(nomes);

        System.out.println("-".repeat(15));

        nomes.clear();
        if (nomes.isEmpty()) {
            System.out.println("Ta vazia...");
        } else {
            System.out.println("Ta lotada...");
        }

    }
}
