package org.example;

public class Main {
    public static void main(String[] args) {

        Aluno big = new Aluno("Bruno Henrique", 100);
        Aluno caio = new Aluno("Caio Arnoni", 101);
        Aluno paulo = new Aluno("Paulo Reis", 102);
        big.adicionarNota(9.9);
        big.adicionarNota(7.1);
        caio.adicionarNota(10.0);
        caio.adicionarNota(6.0);
        paulo.adicionarNota(10.0);
        paulo.adicionarNota(5.0);

        Turma umCCO = new Turma();

        umCCO.adicinarAluno(big);
        umCCO.adicinarAluno(caio);
        umCCO.adicinarAluno(paulo);

        System.out.println(umCCO.getAlunoPorRa(1001));

        System.out.println(umCCO.getAlunoPorNome("Bruno"));

        System.out.println(umCCO.getAlunoComMaiorMedia());
        System.out.println(umCCO.getAlunoComMenorMedia());
        System.out.println(umCCO.calcularMediaTurma());


    }
}