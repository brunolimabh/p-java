package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        String nome;
        String senha;
        Boolean isErro = true;
        Integer opcao;
        Integer valor;
        Double valorConvertido = 0.0;
        Integer opcaoMoeda;
        String moedaEscolhida = "";

        do {
            System.out.println("Insira o nome de usuário:");
            nome = inputString.nextLine();
            System.out.println("Insira a senha do usuáiro:");
            senha = inputString.nextLine();
            if (nome.equals("urubu100") && senha.equals("urubu100")){
                isErro = false;
            } else {
                System.out.println("Usuário ou senha errado.\nTente novamente...\n");
            }
        }while (isErro);

        System.out.println("Bem-vindo, %s!".formatted(nome));

        do {
            System.out.println("""
                    1 - Conversor de moedas
                    2 - Sair
                    """);
            opcao = inputNumber.nextInt();
            if (opcao == 1){

                System.out.println("Insira a quantidade de moedas em inteiro a ser convertido:");
                valor = inputNumber.nextInt();
                do {
                    System.out.println("""
                            Qual moeda você deseja converter?
                            1 - Bitcoin
                            2 - Ethereum
                            3 - Solana
                            0 - Sair
                            
                            """);
                    opcaoMoeda = inputNumber.nextInt();
                    if (opcaoMoeda == 0) {
                        opcao = 3;
                    } else {
                        if (opcaoMoeda == 1) {
                            moedaEscolhida = "Bitcoin";
                            valorConvertido = valor * 127508.27;
                        } else if (opcaoMoeda == 2) {
                            moedaEscolhida = "Ethereum";
                            valorConvertido = valor * 8034.20;
                        } else if (opcaoMoeda == 3) {
                            moedaEscolhida = "Solana";
                            valorConvertido = valor * 96.06;
                        } else {
                            System.out.println("Insira uma opção válida");
                        }
                        if (opcaoMoeda == 1 || opcaoMoeda == 2 || opcaoMoeda == 3) {
                            System.out.println("Com %d da moeda %s, você teria aproximadamente R$%.2f"
                                    .formatted(valor, moedaEscolhida, valorConvertido));
                        }
                    }

                }while (opcaoMoeda != 0);


            } else if (opcao == 2) {
                System.out.println("Até logo, %s".formatted(nome));
            } else {
                System.out.println("Voltando para o menu");
            }
        }while (opcao != 2);

    }
}