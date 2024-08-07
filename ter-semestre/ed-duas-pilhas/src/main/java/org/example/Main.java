package org.example;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {5, -3, 9, -2, 7, -8};

        DuasPilhas duasPilhas = new DuasPilhas(vetor.length);

        for (int num : vetor) {
            if (num >= 0) {
                duasPilhas.push(num, 1);
            } else {
                duasPilhas.push(num, 2);
            }
        }

        System.out.println("Números positivos: ");
        while (!duasPilhas.isEmpty(1)) {
            System.out.printf(duasPilhas.pop(1) + " ");
        }

        System.out.println("\nNúmeros negativos: ");
        while (!duasPilhas.isEmpty(2)) {
            System.out.printf(duasPilhas.pop(2) + " ");
        }
    }
}