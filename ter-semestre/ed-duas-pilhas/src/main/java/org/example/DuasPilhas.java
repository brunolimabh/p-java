package org.example;

public class DuasPilhas {

    private int[] vetor;
    private int topo1;
    private int topo2;

    public DuasPilhas(int tamanho) {
        vetor = new int[tamanho];
        topo1 = -1;
        topo2 = tamanho;
    }

    public boolean isEmpty(int pilha) {
        if (pilha == 1) {
            return topo1 == -1;
        } else {
            return topo2 == vetor.length;
        }
    }

    public void push(int valor, int pilha) {
        if (pilha == 1) {
            if (topo1 + 1 < topo2) {
                vetor[++topo1] = valor;
            } else {
                throw new IllegalStateException("Pilha 1 está cheia");
            }
        } else {
            if (topo2 - 1 > topo1) {
                vetor[--topo2] = valor;
            } else {
                throw new IllegalStateException("Pilha 2 está cheia");
            }
        }
    }

    public int peek(int pilha) {
        if (pilha == 1) {
            if (!isEmpty(1)) {
                return vetor[topo1];
            } else {
                throw new IllegalStateException("Pilha 1 está vazia");
            }
        } else {
            if (!isEmpty(2)) {
                return vetor[topo2];
            } else {
                throw new IllegalStateException("Pilha 2 está vazia");
            }
        }
    }

    public int pop(int pilha) {
        if (pilha == 1) {
            if (!isEmpty(1)) {
                return vetor[topo1--];
            } else {
                throw new IllegalStateException("Pilha 1 está vazia");
            }
        } else {
            if (!isEmpty(2)) {
                return vetor[topo2++];
            } else {
                throw new IllegalStateException("Pilha 2 está vazia");
            }
        }
    }

    public boolean isFull() {
        return topo1 + 1 == topo2;
    }

    public void exibe() {
        System.out.println("Pilha 1:");
        for (int i = 0; i <= topo1; i++) {
            System.out.printf(vetor[i] + " ");
        }
        System.out.println("\nPilha 2:");
        for (int i = vetor.length - 1; i >= topo2; i--) {
            System.out.printf(vetor[i] + " ");
        }
        System.out.println();
    }

    public void exibeRecursivo() {
        System.out.println("Pilha 1:");
        exibeRecursivoPilha1(topo1);
        System.out.println("\nPilha 2:");
        exibeRecursivoPilha2(topo2);
        System.out.println();
    }

    private void exibeRecursivoPilha1(int index) {
        if (index >= 0) {
            exibeRecursivoPilha1(index - 1);
            System.out.printf(vetor[index] + " ");
        }
    }

    private void exibeRecursivoPilha2(int index) {
        if (index < vetor.length) {
            System.out.printf(vetor[index] + " ");
            exibeRecursivoPilha2(index + 1);
        }
    }

}
