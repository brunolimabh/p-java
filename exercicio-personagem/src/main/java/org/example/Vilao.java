package org.example;

public class Vilao extends Personagem{
    public Vilao(String codinome, String nome) {
        super(codinome, nome);
    }

    @Override
    public Double getForcaTotal() {
        Double forcaTotal = 0.0;
        for (SuperPoder poderDaVez: super.getPoderes()){
            forcaTotal += poderDaVez.getCategoria();
        }
        return forcaTotal;
    }
}
