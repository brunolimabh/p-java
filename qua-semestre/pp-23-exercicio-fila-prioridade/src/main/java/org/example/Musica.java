
package org.example;

public class Musica {
    private Integer id;
    private String nome;
    private String artista;
    private String duracao;
    private String album;
    private Double nota;
    private String genero;
    private Integer prioridade;

    public Musica(Integer id, String nome, String artista, String duracao, String album, Double nota, String genero, Integer prioridade) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
        this.album = album;
        this.nota = nota;
        this.genero = genero;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", artista='" + artista + '\'' +
                ", duracao='" + duracao + '\'' +
                ", album='" + album + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
