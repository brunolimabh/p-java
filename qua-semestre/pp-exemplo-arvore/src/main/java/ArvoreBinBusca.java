/* Classe ArvoreBinBusca - representa uma Arvore Binaria de busca
 * ou seja, uma Arvore em que os valores que estao a esquerda de um
 * nó são menores ou iguais ao valor do nó, e os valores que estao a 
 * direita de um nó são maiores do que o valor do nó
 */
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
    public void insere(int info) {
        if (raiz == null) {			// se a arvore esta vazia
            raiz = new Node(info);	// então cria a raiz com o conteúdo recebido
        }
        else {			//senão
            Node noDaVez = raiz;	// comeca a percorrer a arvore a partir da raiz

            // enquanto nao inseriu o novo nó
            while (noDaVez != null && noDaVez.getInfo() != info) {
                // cria um novo nó com o conteúdo recebido
                Node noNovo = new Node(info);
                // conteúdo novo eh menor ou igual ao conteúdo do nó da vez ?
                if (info <= noDaVez.getInfo()) {
                    // sim... entao tem que prosseguir para o lado esquerdo
                    if (noDaVez.getEsq() == null) {	// se nó da vez não tem filho esquerdo
                        noDaVez.setEsq(noNovo);		// insere novo nó ai, como filho esquerdo do no da vez
                    }
                    noDaVez = noDaVez.getEsq();		// no da vez passa a ser o filho esq do no da vez
                }
                else {
                    // nao... entao tem que prosseguir para o lado direito
                    if (noDaVez.getDir() == null) {	// se no da vez nao tem filho direito
                        noDaVez.setDir(noNovo);		// insere novo no ai, como filho direito do no da vez
                    }
                    noDaVez = noDaVez.getDir();		// no da vez passa a ser o filho dir do no da vez
                }
            }
        }
    }

    public void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.getInfo() + "\t");
            preOrdem(no.getEsq());
            preOrdem(no.getDir());
        }
    }


}
