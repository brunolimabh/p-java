package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("EX 1");
        int[] vetor = {-1, 2, -3, 4, -5, 6, -7, 8, -9, 10};
        DuasPilhas duasPilhas = new DuasPilhas(vetor.length);
        for (int num: vetor) {
            if (num >= 0) {
                duasPilhas.push(1, num);
            } else {
                duasPilhas.push(2, num);
            }
        }
        duasPilhas.exibe();
        System.out.println();
        System.out.println("EX 2");
        FilaPilha filaPilha = new FilaPilha(10);
        filaPilha.insert(1);
        filaPilha.insert(2);
        filaPilha.insert(3);
        filaPilha.push(10);
        filaPilha.push(20);
        filaPilha.push(30);
        filaPilha.exibe();

        System.out.println();
        System.out.println("EX 3");
        PilhaFila pilhaFila = new PilhaFila(10);
        pilhaFila.insert(1);
        pilhaFila.insert(2);
        pilhaFila.insert(3);
        pilhaFila.push(10);
        pilhaFila.push(20);
        pilhaFila.push(30);
        pilhaFila.exibe();
    }
}