package org.example;
import java.util.Scanner;
public class MiniExercicio02 {
    public static void main(String[] args) {
        Scanner inputNum = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.println("-----BEM-VINDO AO SISTEMA DE NOTAS-----");
        System.out.println("Informe o seu nome:");
        String nome = inputString.nextLine();
        System.out.println("Informe a quantidade de notas:");
        Integer qtdNotas = inputNum.nextInt();
        Double media = 0.0;
        Double[] vtNotas = new Double[qtdNotas];
        for (int i = 0; i < qtdNotas;i++) {
            System.out.printf("Informe a %dª nota: ", i+1);
            vtNotas[i] = inputNum.nextDouble();
            media = media + vtNotas[i];
        }
        media = media/qtdNotas;
        String situacao = media >=6 ? "Aprovado":"Reprovado";
        String mensagem = """
                -----------------
                Nome do aluno: %s
                Média: %.2f
                Situaçãp: %s
                -----------------
                """.formatted(nome,media,situacao);
        System.out.printf(mensagem);
        inputString.close();
        inputNum.close();

    }
}
