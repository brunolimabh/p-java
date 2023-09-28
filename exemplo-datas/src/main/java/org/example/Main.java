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

        LocalDate dataAPartirDoTexto = LocalDate.parse("28/11/2000",formatter);
        System.out.println(dataAPartirDoTexto);

    }
}