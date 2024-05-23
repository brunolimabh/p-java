package org.example;

public class FilaCircular {
    int tamanho, inicio, fim;
    String[] fila;

    public FilaCircular(int capacidade) {
        this.fila = new String[capacidade];
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean isEmpty() {
        return getTamanho() == 0;
    }

    public boolean isFull() {
        return getTamanho() == fila.length;
    }

    public void insert(String info) {
        if (isFull()) throw new IllegalStateException();
        fila[fim] = info;
        tamanho++;
        fim = (fim + 1) % fila.length;
    }

    public String peek() {
        return fila[inicio];
    }

    public String poll() {
        if (isEmpty()) return null;
        String removido = fila[inicio];
        fila[inicio] = null;
        addInicio();
        tamanho = tamanho - 1;
        return removido;
    }

    public void exibe() {
        int exibidos = 0;
        int inicioExibe = getInicio();

        while (exibidos != getTamanho()) {

            System.out.println(fila[inicioExibe]);
            inicioExibe = inicioExibe + 1;
            if (inicioExibe == fila.length) inicioExibe = 0;
            exibidos = exibidos + 1;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public void addFim() {
        fim = fim + 1;
        if (fim == fila.length) fim = 0;
    }

    public void addInicio() {
        inicio = inicio + 1;
        if (inicio == fila.length) inicio = 0;
    }

    // Cria um vetor e percorre a fila adicionando os elementos no vetor (
    // Retorna o vetor criado e não a fila
    // Esse método é equivalente ao exibe, mas em vez de exibir os elementos da fila na console,
    // copia os elementos da fila para um vetor, na ordem em que seriam exibidos
    public String[] getFila(){
        String[] vetor = new String[tamanho];

        int exibidos = 0;
        int inicioExibe = getInicio();

        while (exibidos != getTamanho()) {

            vetor[exibidos] = fila[inicioExibe];
            inicioExibe = inicioExibe + 1;
            if (inicioExibe == fila.length) inicioExibe = 0;
            exibidos = exibidos + 1;
        }
        return vetor;
    }
}

