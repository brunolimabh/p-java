package org.example;

import java.util.Scanner;

public class Encomendas {
    Scanner inputString = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);
    String tamanho = "";
    String enderecoRemetente = "";
    String enderecoDestinatario = "";
    Double distancia = 0.0;
    Double valorEncomenda = 0.0;
    Double valorFrete = 0.0;

    void coletarInfos() {
        System.out.println("Informe o tamanho (P-M-G:");
        tamanho = inputString.nextLine();
        System.out.println("Informe o endereço do remetente:");
        enderecoRemetente = inputString.nextLine();
        System.out.println("Informe o endereço do destinatario:");
        enderecoDestinatario = inputString.nextLine();
        System.out.println("Informe a distancia distancia:");
        distancia = inputNumber.nextDouble();
        System.out.println("Informe o valor da encomenda:");
        valorEncomenda = inputNumber.nextDouble();
    }
    void calcularFrete() {
        if (tamanho.equals("P")){
            valorFrete = valorEncomenda * .01;
        } else if (tamanho.equals("M")) {
            valorFrete = valorEncomenda * .03;
        } else if (tamanho.equals("G")) {
            valorFrete = valorEncomenda * .05;
        }

        if (distancia <= 50){
            valorFrete+= 3;
        } else if (distancia > 50 && distancia < 200) {
            valorFrete+= 5;
        } else {
            valorFrete+= 7;
        }

        System.out.println("O valor do frete é de R$%.2f".formatted(valorFrete));
    }
    void emitirEtiqueta() {
        System.out.println("""
                ***** ETIQUETA PARA ENVIO ***** 
                Endereço do remetente: %s
                Endereço do destinatário: %s
                Tamanho: %s 
                -------------------------------------------------- 
                Valor encomenda: R$ %.2f
                Valor frete: R$ %.2f
                -------------------------------------------------- 
                Valor total: R$ %.2f
                -------------------------------------------------- 
                """.formatted(enderecoRemetente, enderecoDestinatario, tamanho,valorEncomenda,valorFrete, valorEncomenda+valorFrete));
    }

}