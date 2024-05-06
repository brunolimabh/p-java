package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("-".repeat(20));
        System.out.println("EX 1");

        int[] vetor = {10,20,30,20,10};
        System.out.println(ehPalindromo(vetor));

        System.out.println("-".repeat(20));
        System.out.println("EX 2");

        converteParaBinario(32);

        System.out.println("-".repeat(20));
        System.out.println("EX 3");

        PilhaObj pilhaObj = new PilhaObj<>(5);
        pilhaObj.push("bruno");
        pilhaObj.push("paulo");
        pilhaObj.push("caio");
        pilhaObj.exibe();
        System.out.println(pilhaObj.pop());
        System.out.println(pilhaObj.pop());
        System.out.println(pilhaObj.pop());

        System.out.println("-".repeat(20));
        System.out.println("EX 4");

        lerFrase("bruno");

        System.out.println("");
        System.out.println("-".repeat(20));
        System.out.println("EX 5");

        System.out.println(frasePalindroma("anotaram a data da maratona"));
        
    }

    public static boolean ehPalindromo(int vetor[]) {

        Pilha pilha = new Pilha(vetor.length);

        for (int info:vetor) {
            pilha.push(info);
        }

        int j = pilha.getTopo();

        for (int i = 0; i < vetor.length - 1; i++) {

            if (vetor[i] != pilha.pop()) {
                return false;
            }

            j--;
        }

        return true;
    }

    public static void converteParaBinario(int num){
        Pilha pilha = new Pilha((int) (Math.log(num) / Math.log(2)) + 1);

        int resto = num;

        while (resto > 0) {

            if (resto %2 == 0) {
                pilha.push(0);
            } else {
                pilha.push(1);
            }

            resto = resto / 2;


        }

        pilha.exibe();

    }

    public static void lerFrase(String frase) {
        PilhaObj pilhaObj = new PilhaObj<>(frase.length());

        for (int i = 0; i < frase.length(); i++) {
            pilhaObj.push(frase.charAt(i));
        }

        pilhaObj.exibe();

        while (!pilhaObj.isEmpty()) {
            System.out.printf("%s", pilhaObj.pop());
        }
    }

    public static boolean frasePalindroma(String frase) {
        frase = frase.replaceAll(" ", "");
        PilhaObj pilhaObj = new PilhaObj<>(frase.length());

        for (int i = 0; i < frase.length(); i++) {
            pilhaObj.push(frase.charAt(i));
        }

        int j = pilhaObj.getTopo();

        for (int i = 0; i < frase.length() - 1; i++) {

            if (frase.charAt(i) != (char) pilhaObj.pop()) {
                return false;
            }

            j--;
        }

        return true;
    }

}