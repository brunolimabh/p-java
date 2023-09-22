package org.example;

public class Main {
    public static void main(String[] args) {
        Livro big = new Livro("1","bigbig","Bruno",10);

        Double peso = big.calcularPeso();

        Prateleira prat = new Prateleira(10,24.0);
        prat.adicionarLivro(big);

        System.out.println(prat.getPesoTotal());
        System.out.println(prat.getLivroPorNome("bigbig"));
    }
}