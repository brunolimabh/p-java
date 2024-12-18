public class Node {

    // Atributos
    private int info;       // valor do nó
    private Node esq;       // endereço do filho esquerdo desse nó
    private Node dir;       // endereço do filho direito desse nó

    // Construtor
    public Node(int info) {
        this.info = info;
        esq = null;         // inicializa esq e dir com null
        dir = null;
    }

    // Setters e Getters

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
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
