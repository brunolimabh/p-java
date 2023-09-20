package school.sptech;

import java.util.Scanner;

public class Calorias {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite quantos minutos Jorge aqueceu:");
        Integer aquecimento = leitor.nextInt();
        System.out.println("Digite quantos minutos Jorge fez aeróbicos:");
        Integer aerobico = leitor.nextInt();
        System.out.println("Digite quantos minutos Jorge fez musculação:");
        Integer musculacao = leitor.nextInt();

        Integer qtdMinutos = aquecimento + aerobico + musculacao;


        Integer qtdCalorias = (aquecimento * 12) + (aerobico * 20) + (musculacao * 25);

        System.out.println(
                "Olá, Jorge. Você fez um total de " + qtdMinutos +
                " minutos de exercícios e perdeu cerca de " + qtdCalorias +
                " calorias");
    }

}
