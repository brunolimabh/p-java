package org.example;

public class Funcionario {
    private String nome;
    private String nomeMae;
    private int cursos;
    private int filhos;
    private double salario;
    private double altura;
    private double peso;

    public Funcionario(String nome, String nomeMae, int cursos, int filhos, double salario, double altura, double peso) {
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.cursos = cursos;
        this.filhos = filhos;
        this.salario = salario;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public int getCursos() {
        return cursos;
    }

    public void setCursos(int cursos) {
        this.cursos = cursos;
    }

    public int getFilhos() {
        return filhos;
    }

    public void setFilhos(int filhos) {
        this.filhos = filhos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", nomeMae='").append(nomeMae).append('\'');
        sb.append(", cursos=").append(cursos);
        sb.append(", filhos=").append(filhos);
        sb.append(", salario=").append(salario);
        sb.append(", altura=").append(altura);
        sb.append(", peso=").append(peso);
        sb.append('}');
        return sb.toString();
    }
}
