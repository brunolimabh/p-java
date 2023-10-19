package org.example;

public class AlunoGraduacao extends Aluno{

    private Double nota3;

    public AlunoGraduacao(String ra, String nome, Double nota1, Double nota2, Double nota3) {
        super(ra, nome, nota1, nota2);
        this.nota3 = nota3;
    }

    @Override
    public Double getMedia() {
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    @Override
    public String toString() {
        return "AlunoGraduacao{" +
                "ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}
