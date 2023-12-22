package org.example;

import com.sun.management.UnixOperatingSystemMXBean;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
            Aluno Pós
            Aluno Bacharelado
            Aluno Téc.
         */

        List<Aluno> alunos = new ArrayList<>();

        AlunoPos a1 = new AlunoPos("12345","Diego Limbo",10.0);
        alunos.add(a1);

        AlunoTecnologo tec1 = new AlunoTecnologo("2323","Cerejo",10.0,7.5);
        alunos.add(tec1);

        for (Aluno alunoDaVez: alunos){
            System.out.println(alunoDaVez.getNome());
        }
    }
}