package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] t1 = new String[10];
        String[] t1Att;
        int t1Qtd = -1;
        String[] t2 = new String[10];
        String[] t2Att;
        int t2Qtd = -1;

        for (int i = 0; i < 10 ; i++) {
            System.out.println("Nome do aluno n° %d : ".formatted(i+1));
            String nome = leitor.nextLine();

            System.out.println("Turma do aluno (T1 / T2): ");
            String turma = leitor.nextLine();

            if (turma.equalsIgnoreCase("T1")){
                t1[++t1Qtd] = nome;
            } else {
                t2[++t2Qtd] = nome;
            }
        }

        t1Att = new String[t1Qtd+1];
        t2Att = new String[t2Qtd+1];

        for (int i = 0; i < t1Qtd+1; i++) {
            t1Att[i] = t1[i];
        }

        for (int i = 0; i < t2Qtd+1; i++) {
            t2Att[i] = t2[i];
        }

        System.out.println("T1: " + Arrays.toString(t1Att));
        System.out.println("T2: " + Arrays.toString(t2Att));

    }
}