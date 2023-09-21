package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> contatos;

    public Grupo(String nome) {
        this.nome = nome;
        this.contatos = new ArrayList<>();
    }

    public void adiciona(Contato novoContato) {
        this.contatos.add(novoContato);
    }
    public void remove(Contato contato) {
        this.contatos.remove(contato);
    }

    public Contato buscarPorContato(String numero) {
        for (Contato contatoDaVez : contatos){
            if (contatoDaVez.getTelefone().equals(numero)){
                return contatoDaVez;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "nome='" + nome + '\'' +
                ", contatos=" + contatos +
                '}';
    }
}
