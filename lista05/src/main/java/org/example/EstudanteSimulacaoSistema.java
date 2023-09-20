package org.example;

public class EstudanteSimulacaoSistema {
    public static void main(String[] args) {

        Estudante estudante = new Estudante(
                "Manoel", "CCO", 1500.00, "Ativa");

        estudante.aplicarDesconto(10.00);

        estudante.trancarMatricula();

        estudante.aplicarDesconto(5.00);

    }
}
