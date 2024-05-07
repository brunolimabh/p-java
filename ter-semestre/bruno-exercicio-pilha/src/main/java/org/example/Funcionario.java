package org.example;

public class Funcionario {

    private int id;
    private String nome;
    private int filhos;
    private double salario;


    public Funcionario(String nome, int filhos, double salario) {
        this.nome = nome;
        this.filhos = filhos;
        this.salario = salario;
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

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", filhos=" + filhos +
                ", salario=" + salario +
                '}';
    }
}
