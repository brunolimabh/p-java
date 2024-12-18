package org.example;

public class ArvoreBinBusca {

    // Atributo
    private Node raiz;

    // Construtor
    public ArvoreBinBusca() {
        raiz = null;
    }

    // getRaiz()
    public Node getRaiz() {
        return raiz;
    }

    // Método insere - recebe o valor do info do novo nó
    public void insere(Aluno info) {
        if (raiz == null) {
            raiz = new Node(info);
        }
        else {
            Node noDaVez = raiz;

            while (noDaVez != null && noDaVez.getInfo() != info) {
                Node noNovo = new Node(info);

                if (info.getPontuacao() <= noDaVez.getInfo().getPontuacao()) {
                    if (noDaVez.getEsq() == null) {
                        noDaVez.setEsq(noNovo);
                        return;
                    }
                    noDaVez = noDaVez.getEsq();
                }
                else {
                    if (noDaVez.getDir() == null) {
                        noDaVez.setDir(noNovo);
                        return;
                    }
                    noDaVez = noDaVez.getDir();
                }
            }
        }
    }

    public void preOrdem(Node no) {
        if (no != null) {
            System.out.println(no.getInfo() + "\n");
            preOrdem(no.getEsq());
            preOrdem(no.getDir());
        }
    }

    public void emOrdem(Node no) {
        if (no != null) {
            emOrdem(no.getEsq());
            System.out.println(no.getInfo());
            emOrdem(no.getDir());
        }
    }

    public void posOrdem(Node no) {
        if (no != null) {
            posOrdem(no.getEsq());
            posOrdem(no.getDir());
            System.out.println(no.getInfo());
        }
    }
}
