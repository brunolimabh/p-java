package org.example;

public class Main {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("0001","Manoel",10.0,7.5);
        System.out.println(aluno);

        System.out.println(aluno.getMedia());
    }
}