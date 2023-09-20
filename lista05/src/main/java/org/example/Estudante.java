package org.example;

public class Estudante {

    private String nome;
    private String curso;
    private Double mensalidade;
    private String matricula;

    public Estudante(String nome, String curso, Double mensalidade, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.mensalidade = mensalidade;
        this.matricula = matricula;
    }

    public void aplicarDesconto(Double porcentagem) {
        if (matricula.equals("Ativa")) {
            mensalidade = mensalidade * (1-(porcentagem/100));
            System.out.println("Com %.1f%% de desconto, a mensalidade de %s foi para R$%.2f"
                    .formatted(porcentagem, nome, mensalidade));
        } else {
            System.out.println("A matrícula de %s está inativa");
        }
    }

    public void trancarMatricula() {
        matricula = "Inativa";
    }

}
