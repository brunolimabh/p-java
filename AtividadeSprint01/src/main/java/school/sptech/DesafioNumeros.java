package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioNumeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> numeros = new ArrayList();
        List<Integer> par = new ArrayList();
        List<Integer> impar = new ArrayList();

        Integer inteiro = 0;
        do {
            System.out.println("Informe um número inteiro:");
            inteiro = input.nextInt();
            if (inteiro != 0) {
                numeros.add(inteiro);
            }
        }while (!inteiro.equals(0));

        Integer soma = 0;
        Integer menor = 10000000;
        Integer maior = -1;

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) %2 == 0) {
                par.add(numeros.get(i));
            } else {
                impar.add(numeros.get(i));
            }
            if (numeros.get(i) > maior) {
                maior = numeros.get(i);
            }
            if (numeros.get(i) < menor) {
                menor = numeros.get(i);
            }
            soma = soma + numeros.get(i);
        }
        System.out.println("""
                Pares: %s
                Impares: %s
                Soma: %d
                Menor: %d
                Maior: %d
                """.formatted(par, impar, soma, menor, maior));
    }
}
