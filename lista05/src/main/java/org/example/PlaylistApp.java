package org.example;


public class PlaylistApp {

    public static void main(String[] args) {

        Playlist dbv = new Playlist();
        Musica eleE = new Musica("Ele é","Os Arrais", "Louvor", 4.15);
        Musica lugarMelhor = new Musica("Lugar Melhor","Nova Semente", "Louvor", 2.85);
        Musica entregaConfia = new Musica("Entrega e Confia","Daniel Ludkte", "Louvor", 3.0);

        dbv.adicionarMusica(eleE);
        dbv.adicionarMusica(entregaConfia);
        dbv.adicionarMusica(lugarMelhor);
        dbv.exibirMusicas();
        dbv.getDuracao();
        dbv.removerMusica(entregaConfia);
        dbv.exibirMusicas();
        dbv.getDuracao();
    }
}
