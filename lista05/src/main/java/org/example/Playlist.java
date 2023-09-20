package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica musica) {
       this.musicas.add(musica);
    }
    public void removerMusica(Musica musica) {
        this.musicas.remove(musica);
    }
    public void exibirMusicas() {
        for (int i = 0; i < musicas.size(); i++) {
            Musica musicaAtual = musicas.get(i);
            System.out.println("%d. %s - %s"
                    .formatted(i+1,musicaAtual.getNome(), musicaAtual.getArtista()));
        }
    }

    public void getDuracao() {
        Double duracaoTotal = 0.0;
        for (int i = 0; i < musicas.size(); i++) {
            Musica musicaAtual = musicas.get(i);
            duracaoTotal += musicaAtual.getDuracao();
        }
        System.out.println("Duração total da playlist: %.2f".formatted(duracaoTotal));
    }
}
