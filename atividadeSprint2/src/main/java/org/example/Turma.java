package org.example;

import java.util.ArrayList;
import java.util.List;

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
    /* nao esta pesquisando do jeito certo */
    public List<Aluno> getAlunoPorNome(String nome) {
        List<Aluno> pesquisa = new ArrayList<>();
        for (Aluno alunoDaVez : turma) {
            if (alunoDaVez.getNome().equalsIgnoreCase(nome)) {
                pesquisa.add(alunoDaVez);
            }
            return pesquisa;
        }
        return null;
    }
    /* if nao esta funcionando */
    public Aluno getAlunoComMaiorMedia() {
        Aluno maiorNota = null;
        Double media = 0.0;
        for (Aluno alunoDaVez: turma) {
            Double mediaDaVez = alunoDaVez.calcularMedia();
            if (mediaDaVez >= media);
            maiorNota = alunoDaVez;
            media = alunoDaVez.calcularMedia();
        }
        return maiorNota;
    }
    /* if nao esta funcionando */
    public Aluno getAlunoComMenorMedia() {
        Aluno menorNota = null;
        Double media = 100000.0;
        for (Aluno alunoDaVez: turma) {
            if (alunoDaVez.calcularMedia() < media);
            menorNota = alunoDaVez;
            media = alunoDaVez.calcularMedia();
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
        List<Double> notas = new ArrayList<>();
        for (Aluno alunoDaVez: turma){
            notas.add(alunoDaVez.calcularMedia());
        }
        return mediana;
    }
}
