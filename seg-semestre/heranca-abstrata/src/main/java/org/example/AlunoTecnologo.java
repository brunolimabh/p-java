package org.example;

public class AlunoTecnologo extends Aluno{

    private Double nota1;
    private Double nota2;

    public AlunoTecnologo(String ra, String nome, Double nota1, Double nota2) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    @Override
    public Double calcularMedia() {
        return null;
    }
}
