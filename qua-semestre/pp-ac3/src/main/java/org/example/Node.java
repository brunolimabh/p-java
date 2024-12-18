package org.example;

public class Node {

    // Atributos
    private Aluno info;
    private Node esq;
    private Node dir;

    public Node(Aluno info) {
        this.info = info;
        esq = null;
        dir = null;
    }

    public Aluno getInfo() {
        return info;
    }

    public void setInfo(Aluno info) {
        this.info = info;
    }

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }
}
