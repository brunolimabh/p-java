package org.example;

public class Funcionario {
    private int id;
    private String nome;
    private int cursos;
    private int filhos;
    private double salario;
    private double altura;
    private double peso;

    public Funcionario(int id, String nome, int cursos, int filhos, double salario, double altura, double peso) {
        this.id = id;
        this.nome = nome;
        this.cursos = cursos;
        this.filhos = filhos;
        this.salario = salario;
        this.altura = altura;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cursos=" + cursos +
                ", filhos=" + filhos +
                ", salario=" + salario +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
