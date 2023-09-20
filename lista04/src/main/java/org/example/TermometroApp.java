package org.example;

import java.util.Scanner;

public class TermometroApp {
    public static void main(String[] args) {
        Termometro sp = new Termometro();

        sp.temperaturaAtual = 10.;
        sp.temperaturaMin = 5.;
        sp.temperaturaMax = 15.;

        System.out.println("""
                Temp máxima: %.1f
                Temp mínima: %.1f
                Temp atual: %.1f
                """.formatted(sp.temperaturaMax, sp.temperaturaMin, sp.temperaturaAtual));
        sp.aumentaTemperatura();
        sp.diminuiTemperatura();
        sp.exibeFahreinheit();


    }
}