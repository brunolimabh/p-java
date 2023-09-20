package org.example;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfeitariaApp {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        Confeitaria loja = new Confeitaria();

        System.out.println("1 - Comprando 3 bolos");

        loja.inserir3Bolos();

        System.out.println("2 - Comprando 5 bolos");

        loja.comprarBolo();

        System.out.println("3 - Exibindo relatório");

        loja.exibirRelatorio();



    }
}