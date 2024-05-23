package org.example;

public class FilaObj<T> {

    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        this.tamanho = 0;
        this.fila = (T[]) new Object[capacidade];
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isEmpty() {
        return getTamanho() == 0;
    }

    public boolean isFull() {
        return getTamanho() == fila.length;
    }

    public void insert(T info) {
        if (isFull()) throw new IllegalStateException();
        fila[getTamanho()] = info;
        tamanho++;
    }

    public T peek() {
        return fila[0];
    }

    public T poll() {
        if (isEmpty()) throw new IllegalStateException();
        T info = peek();
        for (int i = 0; i < getTamanho() - 1; i++) {
            if (i == getTamanho() - 2) {
                fila[i] = fila[i+1];
                fila[i+1] = null;
            } else {
                fila[i] = fila[i+1];
            }
        }
        tamanho--;
        return info;
    }

    public void exibe() {
        for (T info: fila) {
            if (info != null) System.out.printf(info.toString() + " ");
        }
    }

    // Retorna o vetor fila
    public T[] getFila() {
        return fila;
    }
}