package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("-".repeat(15));

        Aluno aluno = new Aluno("0001","Manoel",10.0,7.5);
        System.out.println(aluno);
        System.out.println(aluno.getMedia());

        System.out.println("-".repeat(15));

        AlunoGraduacao g1 = new AlunoGraduacao("0002","Diego",10.5, 7.5,6.5);
        System.out.println(g1);
        System.out.println(g1.getMedia());

        System.out.println("-".repeat(15));

        Aluno g2 = new AlunoGraduacao("0002","Diego",10.5, 7.5,6.5);
        System.out.println(g2);
        System.out.println(g2.getMedia());

        System.out.println("-".repeat(15));


    }
}
