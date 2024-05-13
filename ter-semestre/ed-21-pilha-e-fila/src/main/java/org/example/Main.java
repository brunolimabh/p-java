package org.example;

public class Main {
    public static void main(String[] args) {

        int[] vetor = {2,7,-3,-50,45,-4,30,-21,38};
        separaPositivoNegativoEmOrdem(vetor);
        separaPositivoNegativoOrdemDiferente(vetor);

    }

    public static void separaPositivoNegativoEmOrdem(int[] vetor) {
        FilaObj negativos = new FilaObj<>(vetor.length);
        FilaObj positivos = new FilaObj<>(vetor.length);

        for (int num: vetor) {
            if (num < 0) negativos.insert(num);
            if (num >= 0) positivos.insert(num);
        }

        int tamNegativo = negativos.getTamamho();
        int tamPositivo = positivos.getTamamho();

        for (int i = 0; i < tamPositivo ; i++) {
            System.out.printf(positivos.poll().toString() + " ");
        };
        for (int i = 0; i < tamNegativo ; i++) {
            System.out.printf(negativos.poll().toString() + " ");
        };
        System.out.println("");
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor) {
        FilaObj negativos = new FilaObj<>(vetor.length);
        FilaObj positivos = new FilaObj<>(vetor.length);

        for (int num: vetor) {
            if (num < 0) negativos.insert(num);
            if (num >= 0) positivos.insert(num);
        }

        int tamNegativo = negativos.getTamamho();
        int tamPositivo = positivos.getTamamho();

        for (int i = 0; i < tamPositivo ; i++) {
            System.out.printf(positivos.poll().toString() + " ");
        };

        PilhaObj pilha = new PilhaObj(vetor.length);

        for (int i = 0; i < tamNegativo ; i++) {
            pilha.push(negativos.poll());
        };

        int tamPilha = pilha.getTopo();

        for (int i = 0; i <=  tamPilha; i++) {
            System.out.printf(pilha.pop().toString() + " ");
        };
        System.out.println("");

    }

}