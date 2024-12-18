package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Cria uma lista de alunos
        List<Aluno> lista = new ArrayList();
        lista.add(new Aluno(20000, "Clara Teixeira", "CCO", 7.0, 400));
        lista.add(new Aluno(20001, "Beatriz Machado", "ADS", 6.0, 200));
        lista.add(new Aluno(20002, "Claudio Silva", "CCO", 7.5, 700));
        lista.add(new Aluno(20003, "Rodolfo Miranda", "CCO", 6.5, 500));
        lista.add(new Aluno(20004, "Horacio Bispo", "ADS", 8.0, 300));
        lista.add(new Aluno(20005, "Fabiola Chagas", "CCO", 8.5, 1000));
        lista.add(new Aluno(20006, "Ana Sousa", "ADS", 9.0, 900));

        ArvoreBinBusca arvore = new ArvoreBinBusca();
        for (Aluno aluno:lista) {
            arvore.insere(aluno);
        };

        System.out.println("EM ORDEM");
        arvore.emOrdem(arvore.getRaiz());
        System.out.println("-".repeat(60));
        System.out.println("POS ORDEM");
        arvore.posOrdem(arvore.getRaiz());
        System.out.println("-".repeat(60));
        System.out.println("PRE ORDEM");
        arvore.preOrdem(arvore.getRaiz());
    }
}