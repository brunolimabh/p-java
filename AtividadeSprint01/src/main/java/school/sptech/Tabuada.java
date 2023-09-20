package school.sptech;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Integer operador = 0;
        do {
            Integer resultado = 0;
            do {
                System.out.println("""
                DIGITE O NÚMERO CORRESPONDENTE A OPERAÇÃO DESEJADA:
                
                1 - SOMA
                2 - MULTIPLICAÇÃO
                3 - DIVISÃO
                4 - SUBTRAÇÃO
                0 - SAIR
                """);
                operador = inputNum.nextInt();
                if (operador == 0) {
                    System.out.println("Até logo!");
                    return;
                }
            }while (operador < 0 || operador > 4);
            System.out.println("Informe o número da tabuada:");
            Integer tabuada = inputNum.nextInt();
            String simbolo = "";

            for (Integer i = 0; i < 10; i++) {
                if (operador == 1) {
                    resultado = tabuada + (i+1);
                    simbolo = "+";
                } else if (operador == 2) {
                    resultado = tabuada * (i+1);
                    simbolo = "*";
                } else if (operador == 3) {
                    resultado = tabuada / (i+1);
                    simbolo = "/";
                } else {
                    resultado = tabuada - (i+1);
                    simbolo = "-";
                }

                System.out.println("%d %s %d = %d"
                        .formatted(tabuada,simbolo,(i+1),resultado));
            }
        } while (!operador.equals("0"));

    }
}
