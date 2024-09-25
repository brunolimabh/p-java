package org.example;

public class Musica {
    private int id;
    private String nome;
    private String cantor;
    private Double duracao;
    private String album;

    public Musica(int id, String nome, String cantor, Double duracao, String album) {
        this.id = id;
        this.nome = nome;
        this.cantor = cantor;
        this.duracao = duracao;
        this.album = album;
    }

    public Musica() {
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

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cantor='" + cantor + '\'' +
                ", duracao=" + duracao +
                ", album='" + album + '\'' +
                '}';
    }
}
