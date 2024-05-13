package org.example;

public class FilaObj<T> {

    private int tamamho;
    private T[] fila;

    public FilaObj(int capacidade) {
        this.tamamho = 0;
        this.fila = (T[]) new Object[capacidade];
    }

    // 03) MÃ©todo isEmpty
    public Boolean isEmpty() {
        return getTamamho() == 0;
    }

    public Boolean isFull() {
        return getTamamho() == fila.length;
    }

    public void insert(T info) {
        if (isFull()) throw new IllegalStateException();
        fila[getTamamho()] = info;
        tamamho++;
    }

    public T peek() {
        return fila[0];
    }

    public T poll() {
        if (isEmpty()) throw new IllegalStateException();
        T info = peek();
        for (int i = 0; i < getTamamho() - 1; i++) {
            if (i == getTamamho() - 2) {
                fila[i] = fila[i+1];
                fila[i+1] = null;
            } else {
                fila[i] = fila[i+1];
            }
        }
        tamamho--;
        return info;
    }

    public void exibe() {
        for (T info: fila) {
            if (info != null) System.out.printf(info.toString() + " ");
        }
    }

    public int getTamamho() {
        return tamamho;
    }

}
