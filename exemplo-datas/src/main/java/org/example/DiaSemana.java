package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DiaSemana {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE");
        
        System.out.println("Digite uma data");
        LocalDate data = LocalDate.parse(input.next(),formatter);
        LocalDate dataAgora = LocalDate.now();

        if (data.isEqual(dataAgora)) {
            System.out.println("O dia %s é hoje e é %s "
                    .formatted(formatter.format(data), formatter2.format(data)));
        } else if (dataAgora.isBefore(data)) {
            System.out.println("O dia %s será %s "
                    .formatted(formatter.format(data), formatter2.format(data)));
        } else {
            System.out.println("O dia %s foi %s "
                    .formatted(formatter.format(data), formatter2.format(data)));
        }
    }
}
