package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Confeitaria {
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString= new Scanner(System.in);
    List<String> bolos = new ArrayList<>();
    List<Integer> valores = new ArrayList<>();
    Integer valor = 0;
    Integer valorTotal = 0;
    Integer qtdVendida = 0;
    String sabor = "";
    Boolean isAchou = false;
    Integer intergerDigitado = 0;
    Double doubleDigitado = 0.0;

    void inserir3Bolos() {
        for (Integer i = 0; i <= 2; i++) {
            System.out.println("Informe o sabor do %dº bolo:".formatted(i+1));
            bolos.add(inputString.nextLine());
            System.out.println("Informe o valor do %dº bolo (entre 30-50):".formatted(i+1));
            valores.add(inputNumber.nextInt());
        }
    }
    void comprarBolo() {
        System.out.println("Informe a quantidade de bolos:");
        intergerDigitado = inputNumber.nextInt();
        if (intergerDigitado >= 100) {
            System.out.println("Seu pedido ultrapassou nosso limite diário para esse bolo");
        } else {
            qtdVendida = intergerDigitado;
            System.out.println("Qual o sabor do bolo?");
            sabor = inputString.nextLine();
            for (int i = 0; i < bolos.size(); i++) {
                if (sabor.equals(bolos.get(i))) {
                    valor = valores.get(i);
                    sabor = bolos.get(i);
                    valorTotal = valor * qtdVendida;
                    isAchou = true;
                }
            }
            if (!isAchou) {
                System.out.println("Insira um sabor válido");
                comprarBolo();
            }
        }
    }

    void exibirRelatorio() {
        System.out.println("O bolo sabor %s, foi comprado %d vezes hoje, totalizando R$%d,00"
                .formatted(sabor, qtdVendida, valorTotal));
    }


}