package school.sptech;

import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {

        // ira executar leitura de coisas digitadas no terminal pelo usuario
        // System.in - entrada padrao do sitema = terminal
        Scanner leitor =
                new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitor.nextLine();

        System.out.println("Ola " + nome);

        System.out.println("Agora, sua idade: ");
        Integer idade = leitor.nextInt();

        System.out.println(
                "Nome: " + nome +
                "\nIdade: " + idade);

        String mensagem = idade > 30 ? "Veão" : "Jofem";

        System.out.println(mensagem);

    }
}
