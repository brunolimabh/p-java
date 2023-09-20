package school.sptech;

import java.util.Scanner;

public class TabuadaMelhorada {
    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Integer operador = 0;
        do {
            Double resultado = 0.0;
            do {
                System.out.println("""
                DIGITE O NÚMERO CORRESPONDENTE A OPERAÇÃO DESEJADA:
                
                1 - SOMA
                2 - MULTIPLICAÇÃO
                3 - DIVISÃO
                4 - SUBTRAÇÃO
                5 - POTÊNCIA
                6 - RESTO
                0 - SAIR
                """);
                operador = inputNum.nextInt();
                if (operador == 0) {
                    System.out.println("Até logo!");
                    return;
                }
            }while (operador < 0 || operador > 6);
            System.out.println("Informe o número da tabuada:");
            Double tabuada = inputNum.nextDouble();
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
                } else if (operador == 4){
                    resultado = tabuada - (i+1);
                    simbolo = "-";
                } else if (operador == 5){
                    resultado = Math.pow(tabuada,(i+1));
                    simbolo = "^";
                } else {
                    resultado = tabuada %(i+1);
                    simbolo = "%";
                }

                System.out.println("%.0f %s %d = %.0f"
                        .formatted(tabuada,simbolo,(i+1),resultado));
            }
        } while (operador != 0);

    }
}
