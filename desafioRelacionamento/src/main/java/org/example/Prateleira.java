package org.example;

import java.util.ArrayList;
import java.util.List;

public class Prateleira {
    private List<Livro> livros;
    private Integer limite;
    private Double peso;

    public Prateleira(Integer limite, Double peso) {
        this.livros = new ArrayList<>();
        this.limite = limite;
        this.peso = peso;
    }

    public void adicionarLivro(Livro livro){
        if (livros.size() >= limite){
            System.out.println("Sua prateleira está cheia");
        } else {
            livros.add(livro);
        }
    }
    public Integer qtdLivro() {
        return livros.size();
    }

    public void removerLivro(String codigo) {
        for (Livro livroDaVez : livros) {
            if (livroDaVez.getCodigo().equals(codigo)) {
                livros.remove(livroDaVez);
                System.out.println("Livro removido");
                break;
            } else {
                System.out.println("Não existe livro com este código");
            }
        }
    }

    public Double getPesoTotal(){
        Double pesoTotal = this.peso;

        for (Livro livroDaVez : livros) {
            pesoTotal += livroDaVez.calcularPeso();
            return pesoTotal;
        }
        return null;
    }
    public Livro getLivroPorNome(String nome){
        for (Livro livroDaVez : livros) {
            if (livroDaVez.getNome().equals(nome)) {
                return livroDaVez;
            } else {
                System.out.println("Não existe livro com este nome");
            }
        }
        return null;
    }
}
