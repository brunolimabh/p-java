package org.example;

public class Concatenacao {
    public static void main(String[] args) {
        System.out.println("Exercício 07 - Contador Variado\n");
        String nome = "Bruno";
        String sobrenome = "Henrique";
        Integer idade = 11;
        Double altura = 1.83;

        System.out.println(String.format("Meu nome é %s %s e tenho %d anos, com altura de %,.2f",
                nome, sobrenome, idade, altura));
        System.out.println(String.format("Meu nome é %s %s e tenho %05d anos, com altura de %,.2f",
                nome, sobrenome, idade, altura));
    }

}
