package org.example;

import java.util.Scanner;

public class Empresa {
    Scanner inputNumber = new Scanner(System.in);
    String nome = "";
    String cargo = "";
    Double salario = 0.0;

    void reajustarSalario() {
        System.out.println("Informe o porcentual de reajuste:");
        Double reajuste = inputNumber.nextDouble();
        salario = salario + (salario * (reajuste / 100));
        System.out.println("O empregado %s, de cargo %s, teve um reajuste de %.1f, totalizando um salário de R$%.2f"
                .formatted(nome, cargo, reajuste, salario));
    }
}