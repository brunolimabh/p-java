package org.example.enumeradores;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class ExamploEnum {
    public static void main(String[] args) {

        System.out.println("Escolha uma das possibilidades abaixo;");

        // VETOR
        DiaDaSemanaEnum[] valoresPossiveis = DiaDaSemanaEnum.values();
        for (DiaDaSemanaEnum enumerador : valoresPossiveis){
            System.out.println("-".repeat(15));
            System.out.println(enumerador.getCodigo() + " - " + enumerador.getDescricao());
        }

        Scanner in = new Scanner(System.in);
        int diaEscolhido = in.nextInt();

        DiaDaSemanaEnum enumEcontrado = DiaDaSemanaEnum.of(diaEscolhido);

        if (Objects.nonNull(enumEcontrado)){
            System.out.println("Você escolheu:");
            System.out.println(enumEcontrado.getDescricao());
        } else {
            System.out.println("Dia inválido...");
        }

        switch (enumEcontrado){
            case SEGUNDA -> System.out.println("");
        }

    }
}