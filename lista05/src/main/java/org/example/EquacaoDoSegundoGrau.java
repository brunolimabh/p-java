package org.example;

import java.util.ArrayList;
import java.util.List;

public class EquacaoDoSegundoGrau {

    private Integer a;
    private Integer b;
    private Integer c;

    public EquacaoDoSegundoGrau(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcularRaizes() {
        List<Double> listaReais = new ArrayList<>();

        System.out.println("""
                -------------------
                Calculando fórmula de Bhaskara
                
                a = %d
                b = %d
                c = %d
                """.formatted(this.a, this.b, this.c));

        Integer delta = (this.b * this.b) - (4 * this.a * this.c);
        System.out.println(delta);
        if (delta < 0) {
            System.out.println("A equação não possui raízes iguais, pois Δ < 0");
            System.out.println(listaReais);
        } else if (delta == 0) {
            Double bhaskara1 = (-this.b + (Math.sqrt(delta))) / (2 * this.a);
            System.out.println("A equação tem um número real, pois Δ = 0");
            System.out.println(listaReais);
        } else {
            Double bhaskara1 = (-this.b - (Math.sqrt(delta))) / (2 * this.a);
            Double bhaskara2 = (-this.b + (Math.sqrt(delta))) / (2 * this.a);
            listaReais.add(bhaskara1);
            listaReais.add(bhaskara2);
            System.out.println("A equação tem dois número real, pois Δ > 0");
            System.out.println(listaReais);
        }
    }
}
