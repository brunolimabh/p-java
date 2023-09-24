package org.example;

public class MainStreaming {
    public static void main(String[] args) {
        Filme filme1 = new Filme(10,"Fuga das galinhas", "Desenho", 7.8);
        Filme filme2 = new Filme(11,"Maverick", "Ação", 8.9);

        Streaming netflix = new Streaming();

        netflix.adicionarFilme(filme1);
        netflix.adicionarFilme(filme2);
        System.out.println(netflix.getQuantidadeDeFilmes());
        System.out.println(netflix.getMediaFilmes());
        System.out.println(netflix.getFilmePorNome("maVerick"));
        System.out.println(netflix.getFilmesPorCategoria("Ação"));
        System.out.println(netflix.getFilmeMaiorNota());
        System.out.println(netflix.sortearFilme());


    }
}