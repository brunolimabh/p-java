package org.example;

public class ArvoreBin {
    private Node raiz;

    public ArvoreBin() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void criaRaiz(int info) {
        this.raiz = new Node(info);
    }

    public Node insereDir(Node pai, int info) {
        if (raiz == null) {
            System.out.println("Arvore vazia");
            return null;
        }
        if (pai.getDir() == null) {
            Node novoNo = new Node(info);
            pai.setDir(novoNo);
            return novoNo;
        } else {
            System.out.println("Ja possui filho na direita");
            return null;
        }
    }

    public Node insereEsq(Node pai, int info) {
        if (raiz == null) {
            System.out.println("Arvore vazia");
            return null;
        }
        if (pai.getEsq() == null) {
            Node novoNo = new Node(info);
            pai.setEsq(novoNo);
            return novoNo;
        } else {
            System.out.println("Ja possui filho na esquerda");
            return null;
        }
    }

    public void exibeArvore(Node noDaVez) {
        if (noDaVez != null) {
            System.out.print(noDaVez.getInfo() + " | ");
            
            if (noDaVez.getEsq() != null) {
                System.out.print(" " + noDaVez.getEsq().getInfo() + " <- ");
            }
            if (noDaVez.getDir() != null) {
                System.out.print("-> " + noDaVez.getDir().getInfo() + " ");
            }
            
            System.out.println();

            exibeArvore(noDaVez.getEsq());
            exibeArvore(noDaVez.getDir());
        }
    }
}
