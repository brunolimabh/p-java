package org.example;

public class Main {
    public static void main(String[] args) {

        Imagem img = new Imagem();

        Quadrado q = new Quadrado("preto",10,10.0);
        Retangulo r = new Retangulo("azul",8,3.0,5.0);
        Triangulo t = new Triangulo("amarelo", 9,2.0,4.0);
        Circulo c = new Circulo("verde",7,3.0);

        img.adicionarFigura(q);
        img.adicionarFigura(r);
        img.adicionarFigura(t);
        img.adicionarFigura(c);

        img.exibeFigura();
        System.out.println("-".repeat(15));
        img.exibeSomaArea();
        System.out.println("-".repeat(15));
        img.exibeFiguraAreaMaior20();
        System.out.println("-".repeat(15));
        img.exibeQuadrado();
    }
}