package org.example;

import java.util.stream.IntStream;

public class OperacoesIntStream {

    public static void main(String[] args) {
        int[] valores = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.println("Valroes do vetor:");
        IntStream.of(valores)
                .forEach(v -> System.out.printf("%d ", v));

        System.out.printf("\nContagem: %d", IntStream.of(valores).count());
        System.out.printf("\nMínimo: %d", IntStream.of(valores).min().getAsInt());
        System.out.printf("\nMáximo: %d", IntStream.of(valores).max().getAsInt());
        System.out.printf("\nSoma: %d", IntStream.of(valores).sum());
        System.out.printf("\nMédia: %.2f", IntStream.of(valores).average().getAsDouble());

        System.out.println(IntStream.of(valores).summaryStatistics().getMax());

        System.out.printf("\nSoma dos valores do vetor, usando reduce: %d",
                IntStream.of(valores).reduce(0, (subtotal, y) -> subtotal + y));

        System.out.printf("\nMultiplicação dos valores do vetor, usando reduce: %d",
                IntStream.of(valores).reduce(1, (subtotal, y) -> subtotal * y));

        System.out.printf("\nSoma dos quadrados dos valores do vetor, usando reduce: %d",
                IntStream.of(valores).reduce(1, (subtotal, y) -> subtotal +  y * 2));

        System.out.println("Exibindo valores impares do vetor, ordenados");
        IntStream.of(valores)
                .filter(valor -> valor % 2 != 0)
                .forEach(valor -> System.out.printf("%d ", valor));

        System.out.println("Exibindo valores pares do vetor, multiplicados por 10 e ordenado");
        IntStream.of(valores)
                .filter(valor -> valor % 2 == 0)
                .map(valor -> valor * 10)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));

        System.out.printf("Soma dos inteiros de 1 a 9: %d",
                IntStream.range(1,10).sum());

    }

}
