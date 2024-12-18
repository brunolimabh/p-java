package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStream {

    public static void main(String[] args) {
        Integer[] valores = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
        String[] cores = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

        System.out.printf("Valores originais: %s",
                Arrays.asList(valores));

        System.out.printf("Valores ordenados: %s",
                Arrays.stream(valores)
                        .sorted()
                        .collect(Collectors.toList()));

        List<Integer> maiorQue4 =
                Arrays.stream(valores)
                        .filter(valor -> valor > 4)
                        .collect(Collectors.toList());
    }

}
