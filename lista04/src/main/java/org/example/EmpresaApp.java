package org.example;

public class EmpresaApp {
    public static void main(String[] args) {
        Empresa sptech = new Empresa();

        sptech.nome = "João";
        sptech.cargo = "Analista de Sistemas";
        sptech.salario = 5400.0;

        System.out.println("""
            Empregado: %s
            Cargo: %s
            Salario: R$%.2f
            """. formatted(sptech.nome,sptech.cargo, sptech.salario));
        sptech.reajustarSalario();



    }
}