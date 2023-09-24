package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Streaming {
    List<Filme> filmes;

    public Streaming() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }
    public void removerFilme(Integer id){
        for (Filme filmeDaVez: filmes){
            if (filmeDaVez.getId() == id) {
                filmes.remove(filmeDaVez);
                break;
            }
        }
    }
    public Integer getQuantidadeDeFilmes() {
        return filmes.size();
    }
    public Double getMediaFilmes() {
        Double media = 0.0;
        for (Filme filmeDaVez: filmes) {
            media+= filmeDaVez.getNotaImdb();
        }
        media = media / filmes.size();
        return media;
    }
    public Filme getFilmePorNome(String nome) {
        for (Filme filmeDaVez: filmes) {
            if (filmeDaVez.getNome().equalsIgnoreCase(nome)){
                return filmeDaVez;
            }
        }
        return null;
    }
    public List<Filme> getFilmesPorCategoria(String categoria) {
        List<Filme> filmes = new ArrayList<>();
        for (Filme filmeDaVez: filmes){
            if (filmeDaVez.getCategoria().equalsIgnoreCase(categoria)){
                filmes.add(filmeDaVez);
            }
        }
        return filmes;
    }
    public Filme getFilmeMaiorNota(){
        Double nota = 0.0;
        Filme maiorNota = null;
        for (Filme filmeDaVez: filmes) {
            if (filmeDaVez.getNotaImdb() > nota){
                nota = filmeDaVez.getNotaImdb();
                maiorNota = filmeDaVez;
            }
        }
        return maiorNota;
    }
    public Filme sortearFilme() {
        Filme filmeSorteado = filmes.get(ThreadLocalRandom.current().nextInt(0, filmes.size()));
        return filmeSorteado;
    }
}
