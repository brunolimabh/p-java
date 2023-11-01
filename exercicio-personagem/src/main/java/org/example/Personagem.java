package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    private String codinome;
    private String nome;
    private List<SuperPoder> poderes;

    public Personagem(String codinome, String nome){
        this.codinome = codinome;
        this.nome = nome;
        this.poderes = new ArrayList<>();
    }

    public void adicionarPoder(String nome, Integer categoria){

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
