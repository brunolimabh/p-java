public class ArvoreBin {

    // Atributo
    private Node raiz;

    // Construtor
    public ArvoreBin() {
        raiz = null;
    }

    // Métodos
    public Node getRaiz() {
        return raiz;
    }

    /* Método criaRaiz */
    public void criaRaiz(int info) {
        raiz = new Node(info);
    }

    /* Método insereDir - recebe o endereço do nó pai e o valor do nó
    * filho a ser inserido do lado direito do nó pai */
    public Node insereDir(Node noPai, int info) {
        // se a árvore está vazia ou se o pai já tem filho direito, não insere
        if (raiz == null || noPai.getDir() != null) {
            System.out.println("Inserção inválida!");
            return null;
        }
        Node novo = new Node(info);   // cria o nó novo
        noPai.setDir(novo);           // atribui nó novo para filho direito do nó pai
        return novo;                  // retorna endereço do nó novo
    }

    /* Método insereEsq  - recebe o endereço do nó pai e o valor do nó
    * filho a ser inserido do lado esquerdo no nó pai*/
    public Node insereEsq(Node noPai, int info) {
        // se a árvore está vazia ou se o pai já tem filho esquerdo, não insere
        if (raiz == null || noPai.getEsq() != null) {
            System.out.println("Inserção inválida!");
            return null;
        }
        Node novo = new Node(info);   // cria o nó novo
        noPai.setEsq(novo);           // atribui nó novo para filho esquerdo do nó pai
        return novo;                  // retorna endereço do nó novo
    }

    /* Método exibeArvore */
    public void exibeArvore(Node noDaVez) {
        if (noDaVez != null) {
            // Exibe info do nó da vez
            System.out.print("Info: " + noDaVez.getInfo());
            // Exibe filho esquerdo do nó da vez
            if (noDaVez.getEsq() == null) {
                System.out.print(" | Esq: --");
            }
            else {
                System.out.print(" | Esq: " + noDaVez.getEsq().getInfo());
            }
            // Exibe filho direito do nó da vez
            if (noDaVez.getDir() == null) {
                System.out.print(" | Dir: --");
            }
            else {
                System.out.print(" | Dir: " + noDaVez.getDir().getInfo());
            }
            System.out.println();
            // Chama recursivamente para exibir árvore a partir do filho esquerdo
            exibeArvore(noDaVez.getEsq());
            // Chama recursivamente para exibir árvore a partir do filho direito
            exibeArvore(noDaVez.getDir());
        }
    }

    /* Método preOrdem - exibe o percurso da árvore em pré ordem */
    public void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.getInfo() + "\t");
            preOrdem(no.getEsq());
            preOrdem(no.getDir());
        }
    }




}
