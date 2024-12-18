public class Teste {

    public static void main(String[] args) {
        // Vamos criar a árvore que está desenhada nos slides

        // Criação da árvore vazia
        ArvoreBin arv = new ArvoreBin();

        // Criação da raiz
        arv.criaRaiz(6);

        // Criar os filhos da raiz
        Node no4 = arv.insereEsq(arv.getRaiz(), 4);
        Node no8 = arv.insereDir(arv.getRaiz(), 8);

        // Criar os filhos do nó 4
        Node no2 = arv.insereEsq(no4, 2);
        Node no5 = arv.insereDir(no4, 5);

        // Criar os filhos do nó 2
        Node no1 = arv.insereEsq(no2, 1);
        Node no3 = arv.insereDir(no2, 3);

        // Criar os filhos do nó 8
        Node no7 = arv.insereEsq(no8, 7);
        Node no9 = arv.insereDir(no8, 9);

        // Exibe a árvore
        arv.exibeArvore(arv.getRaiz());

        // Exibe a árvore no percurso preordem
        System.out.println("\nPercurso pre ordem:");
        arv.preOrdem(arv.getRaiz());
        System.out.println();

        // Cria arvore binaria de busca
        ArvoreBinBusca arvBusca = new ArvoreBinBusca();
        // Insere os valores (arvore binaria que esta no slide do material de arvore)
        arvBusca.insere(6);
        arvBusca.insere(4);
        arvBusca.insere(2);
        arvBusca.insere(1);
        arvBusca.insere(5);
        arvBusca.insere(3);
        arvBusca.insere(8);
        arvBusca.insere(7);
        arvBusca.insere(9);

        System.out.println("\nPercurso em pre-ordem da arvore bin de busca:");
        arvBusca.preOrdem(arvBusca.getRaiz());
        System.out.println();



    }
}
