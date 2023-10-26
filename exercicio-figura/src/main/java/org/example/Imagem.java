package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Imagem {
    private List<Figura> figuras;

    public Imagem() {
        this.figuras = new ArrayList<>();
    }

    public void adicionarFigura(Figura f){
        if (Objects.nonNull(f)){
            figuras.add(f);
        }
    }
    public void exibeFigura(){
        for (Figura figuraDaVez: figuras){
            System.out.println(figuraDaVez.toString());
            System.out.println(figuraDaVez.calculaArea());
        }
    }
    public void exibeSomaArea(){
        Double soma = 0.0;
        for (Figura figuraDaVez: figuras){
            System.out.println(figuraDaVez.calculaArea());
            soma += figuraDaVez.calculaArea();
        }
        System.out.println("Total aera: %f".formatted(soma));
    }
    public void exibeFiguraAreaMaior20(){
        for (Figura figuraDaVez: figuras){
            if (figuraDaVez.calculaArea() > 20){
                System.out.println(figuraDaVez.toString());
                System.out.println(figuraDaVez.calculaArea());
            }
        }
    }
    public void exibeQuadrado(){
        for (Figura figuraDaVez: figuras){
            if (figuraDaVez instanceof Quadrado ){
                System.out.println(figuraDaVez.toString());
            }
        }
    }
}
