package org.example;

public class ListaObj <T> {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private T[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem
    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;

    }

    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(T elemento) {
        if (nroElem < vetor.length){
            vetor[nroElem++] = elemento;
        } else {
            throw new IllegalStateException("Lista cheia");
        }
    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) return i;
        }
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public boolean removePeloIndice(int indice) {
        if (indice < nroElem && indice >= 0){
            for (int i = indice; i <= vetor.length - 1 ; i++) {
                if (i == vetor.length -1){
                    vetor[i] = (T) "buraco";
                } else {
                    vetor[i] = vetor[i+1];
                }
            }
            nroElem--;
            return true;
        }
        return false;
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(T elementoARemover) {
        int indice = busca(elementoARemover);
        if (indice != -1) {
            removePeloIndice(indice);
            return true;
        }
        return false;
    }

    // 08) Método getTamanho
    // Retorna o tamanho da lista
    public int getTamanho() {
        return nroElem;
    }

    // 09) Método getElemento
    // Recebe um índice e retorna o elemento desse índice
    // Se o índice for inválido, retorna null
    public T getElemento(int indice) {
        if (indice >= 0 && indice < nroElem) return vetor[indice];
        return null;
    }

    // 10) Método limpa
    // Limpa a lista
    public void limpa() {
        this.vetor = (T[]) new Object[vetor.length];
        nroElem = 0;

    }

    // 11) Método exibe:
    // Exibe os elementos da lista
    public void exibe() {
        for (Object valor: vetor) {
            System.out.println(valor);
        }
    }

    // Get do vetor
    // Não retirar, é usado nos testes
    public T[] getVetor() {
        return vetor;
    }
}
