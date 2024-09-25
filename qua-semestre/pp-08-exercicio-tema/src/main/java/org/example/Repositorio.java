package org.example;

public class Repositorio {
    private ListaLigadaObj<Musica> lista;
    private PilhaLigadaObj<Musica> pilha;
    private FilaLigadaObj<Musica> fila;

    public Repositorio() {
        this.lista = new ListaLigadaObj<>();
        this.pilha = new PilhaLigadaObj<>();
        this.fila = new FilaLigadaObj<>();
    }

    public void salvar (Musica obj) {
        lista.insereNode(obj);
    }

    public void deletarPeloId(int id) {
        for (int i = 0; i <= lista.getTamanho(); i++) {
            if (lista.getElemento(i) != null && lista.getElemento(i).getId() == id) {
                pilha.push(lista.getElemento(i));
                lista.removeNode(lista.getElemento(i));
            }
        }
    }

    public void exibe() {
        lista.exibe();
    }

    public void desfazerDeletar() {
        while (pilha.peek() != null) {
            lista.insereNode(pilha.pop());
        }
    }

    public void agendarSalvar(Musica musica) {
        fila.insert(musica);
    }

    public void executarAgendado() {
        while (fila.peek() != null){
            lista.insereNode(fila.poll());
        }
    }
}
