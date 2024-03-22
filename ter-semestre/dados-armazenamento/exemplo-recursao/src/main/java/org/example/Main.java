package org.example;

public class Main {
    public  static void contagemRegressiva(int n){
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }

    public static void contagemRegresivaRecursivo(int n){
        if (n > 0){
            System.out.println(n);
            contagemRegresivaRecursivo(n - 1);
        } else {
            System.out.println(n);
            System.out.println("Finalizando");
        }
    }

    public static int fatorial(int n){
        if (n == 0){
            return 1;
        } else {
            return n * fatorial(n-1);
        }
    }

    public static void exibeVator(int[] v, int i){
        if (i < v.length){
            System.out.println(v[i]);
            exibeVator(v, i+1);
        }
    }

    public static void exibeVatorInvertido(int[] v, int i){
        if (i >= 0){
            System.out.println(v[i]);
            exibeVatorInvertido(v, i-1);
        }
    }

    public static int potencia(int a, int exp){
        if (exp == 0){
            return -1;
        } else {
            return a * potencia(a, exp-1);
        }
    }


    public static void main(String[] args) {
        int[] vetor = {10,20,30,40,50};
        contagemRegresivaRecursivo(4);

        System.out.println(fatorial(3));
        System.out.println(fatorial(4));
        System.out.println(fatorial(5));

        exibeVator(vetor, 0);
        exibeVatorInvertido(vetor, 4);
    }
}