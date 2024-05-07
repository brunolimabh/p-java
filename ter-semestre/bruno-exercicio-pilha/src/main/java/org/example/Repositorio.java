package org.example;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repositorio {

    private List<Funcionario> lista;
    private PilhaObj<Integer> pilha;
    private int identificador;

    public Repositorio() {
        this.lista = new ArrayList<>();
        this.pilha = new PilhaObj<>(10);
        this.identificador = 101;
    }

    public void salvar(Funcionario func) {
        func.setId(identificador++);
        lista.add(func);
        pilha.push(func.getId());
    }

    public void deletar(int id) {
        Funcionario func = funcExists(id);
        if (func == null) {
            System.out.println("ID Inexistente");
        } else {
            lista.remove(func);
        }
    }

    private Funcionario funcExists(int id) {
        for (Funcionario func: lista) {
            if (func.getId() == id) return func;
        }
        return null;
    }

    public void exibir() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia");
        } else {
            for (Funcionario func:lista) {
                System.out.println(func);
            }
        }
    }

    public void desfazer() {
        if (pilha.isEmpty()) {
            System.out.println("Não há nada a desfazer");
        } else {
            deletar((int) pilha.pop());
        }
    }

}
