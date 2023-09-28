package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2020,9,28);
        LocalDate dataAgora = LocalDate.now();
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        System.out.println(data);
        System.out.println(dataAgora);
        System.out.println(dataHoraAgora);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(formatter.format(dataHoraAgora));

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite uma data:");

        LocalDate dataAPartirDoTexto = LocalDate.parse("28/09/2023",formatter);
        System.out.println(dataAPartirDoTexto);

        LocalDate dataNova = dataAPartirDoTexto.plusDays(10);
        System.out.println(dataNova);

        if (dataAPartirDoTexto.isAfter(dataNova)) {
            System.out.println("Esta");
        } else {
            System.out.println("Não está");
        }

        if (dataAPartirDoTexto.isEqual(dataNova)) {
            System.out.println("É igual");
        } else {
            System.out.println("Não é igual");
        }


        DateTimeFormatter formatter2 = DateTimeFormatter
                .ofPattern("\ndd/MM/yyyy EEEE\n");
        System.out.println(formatter2.format(dataAgora));

        Integer diaSemana = dataAgora.getDayOfWeek().getValue();
        System.out.println(diaSemana);
    }
}