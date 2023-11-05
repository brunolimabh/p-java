package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    private String codinome;
    private String nome;
    private List<SuperPoder> poderes = new ArrayList<>();

    public Personagem(String codinome, String nome){
        this.codinome = codinome;
        this.nome = nome;
    }

    public void adicionarPoder(String nome, Integer categoria){
        SuperPoder poder = new SuperPoder(nome,categoria);
        poderes.add(poder);
    }
    public abstract Double getForcaTotal();

    public String getCodinome() {
        return codinome;
    }

    public String getNome() {
        return nome;
    }

    public List<SuperPoder> getPoderes() {
        return poderes;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "codinome='" + codinome + '\'' +
                ", nome='" + nome + '\'' +
                ", poderes=" + poderes +
                '}';
    }
}
