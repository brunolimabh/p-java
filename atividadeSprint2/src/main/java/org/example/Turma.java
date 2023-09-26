package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.util.Arrays;

public class Turma {
    private List<Aluno> turma;

    public Turma() {
        this.turma = new ArrayList<>();
    }

    /* funcionando */
    public void adicinarAluno(Aluno aluno) {
        turma.add(aluno);
    }
    /* funcionando */
    public Aluno getAlunoPorRa(Integer ra) {
        for (Aluno alunoDaVez : turma) {
            if (alunoDaVez.getRa() == ra) {
                return alunoDaVez;
            }
        }
        return null;
    }
    /* funcionando */
    public List<Aluno> getAlunoPorNome(String nome) {
        List<Aluno> pesquisa = new ArrayList<>();
        for (Aluno alunoDaVez : turma) {
            if (alunoDaVez.getNome().toLowerCase().contains(nome.toLowerCase())) {
                pesquisa.add(alunoDaVez);
            }
        }
        return pesquisa;
    }
    /* funcionando */
    public Aluno getAlunoComMaiorMedia() {
        Aluno maiorNota = null;
        Double media = 0.0;
        for (Aluno alunoDaVez: turma) {
            if (alunoDaVez.calcularMedia() > media){
                maiorNota = alunoDaVez;
                media = alunoDaVez.calcularMedia();
            }
        }
        return maiorNota;
    }
    /* funcionando */
    public Aluno getAlunoComMenorMedia() {
        Aluno menorNota = null;
        Double media = 100000.0;
        for (Aluno alunoDaVez: turma) {
            if (alunoDaVez.calcularMedia() < media) {
                menorNota = alunoDaVez;
                media = alunoDaVez.calcularMedia();
            }
        }
        return menorNota;
    }
    /* funcionando */
    public Double calcularMediaTurma() {
        Double media = 0.0;
        for (Aluno alunoDaVez: turma) {
            media+= alunoDaVez.calcularMedia();
        }
        return media;
    }
    /* funcionando */
    public Double getMediaPorRa(Integer ra) {
        Double media = 0.0;
        for (Aluno alunoDaVez: turma) {
            if (alunoDaVez.getRa() == ra)
            media = alunoDaVez.calcularMedia();
        }
        return media;
    }
    /* verificar como pega a mediana na lista */
    public Double getMediana() {
        Double mediana = 0.0;
        Integer tamanho = 0;
        Integer posicao = 0;
        List<Double> notas = new ArrayList<>();

        for (Aluno alunoDaVez: turma){
            notas.add(alunoDaVez.calcularMedia());
        }

        Collections.sort(notas);
        System.out.println(notas);
        tamanho = notas.size();

        if (tamanho%2 == 0) {
            posicao = (tamanho / 2);
            Integer posicao2 = posicao + 1;
            mediana = (notas.get(posicao-1) + notas.get(posicao2-1)) / 2;
        } else {
            posicao = ((tamanho - 1) / 2) + 1;
            mediana = notas.get(posicao-1);
        }
        return mediana;
    }
}
