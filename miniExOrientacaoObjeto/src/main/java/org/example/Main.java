package org.example;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputNumber = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        System.out.println("--------------------Cofrinho aberto---------------------\n");
        System.out.println("Qual é a sua aquisição?");
        String aquisicao = inputString.nextLine();

        Integer acao;
        do{
            System.out.println("""
                    1 - Guardar dinheiro
                    2 - Agistar cofrinho
                    
                    0 - Quebrar cofrinho                  
                    """);
            acao = inputNumber.nextInt();

            if (acao == 1) {
                cofrinho.cofrinhoDepositar();
            } else if (acao == 2) {
                if (cofrinho.valorCofrinho == 0.0) {
                    System.out.println("Seu cofrinho está vazio, guarde algum valor antes de agitar");
                } else {
                    cofrinho.cofrinhoAgitar();
                }
            } else if (acao != 0){
                System.out.println("Digite um número válido");
            }

        }while (acao != 0);
        System.out.println("""
                Seu cofrinho para %s foi quebrado com o valor de R$%.2f!
                ----------------------Até mais!-------------------------
                """.formatted(aquisicao, cofrinho.valorCofrinho));

    }
}