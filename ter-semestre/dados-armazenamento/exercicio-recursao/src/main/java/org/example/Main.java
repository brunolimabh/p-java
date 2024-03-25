package org.example;

public class Main {
    public static int execricio1(int i){
        if (i == 0) {
            return 0;
        } else {
            return i + execricio1(i - 1);
        }
    }

    public static int execricio2(int[] v, int i){
        if (i < 0) {
            return 0;
        } else {
            return v[i] + execricio2(v, i - 1);
        }
    }

    public static int execricio3(int[] v, int i){
        if (i < 0 ) {
            return 0;
        } else {
            if (v[i] % 2 == 0) {
                return v[i] + execricio3(v, i-1);
            } else {
                return execricio3(v, i-1);
            }
        }
    }

    public static int execricio4(int[] v, int i){
        if (i < 0 ) {
            return 0;
        } else {
            if (v[i] % 2 != 0) {
                return 1 + execricio4(v, i-1);
            } else {
                return execricio4(v, i-1);
            }
        }
    }

    public static int execricio5(int[] v, int i, int n){
        if (i < 0 ) {
            return 0;
        } else {
            if (v[i] == n) {
                return 1 + execricio5(v, i-1, n);
            } else {
                return execricio5(v, i-1, n);
            }
        }
    }

    public static int execricio6(int y, int z){
        if (z == 0) {
            return y;
        } else {
            return execricio6(z, y % z);
        }
    }

    public static int execricio7(int[] v, int i, int m){
        if (i < 0) {
            return m;
        } else {
            if (v[i] > m) {
                return execricio7(v, i - 1, v[i]);
            } else {
                return execricio7(v, i -1, m);
            }
        }
    }

    public static int execricio8(int n){
        if (n < 10) {
            return n;
        } else {
            return n % 10 + execricio8(n / 10);
        }
    }

    public static String execricio9(int n){
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            return execricio9(n/2) + n % 2;
        }
    }


    public static void main(String[] args) {
        int[] vetor2 = {7,3,5,2};

        System.out.println(execricio1(5));
        System.out.println(execricio2(vetor2, 3));
        System.out.println(execricio3(vetor2, 3));
        System.out.println(execricio4(vetor2, 3));
        System.out.println(execricio5(vetor2, 3, 7));
        System.out.println(execricio6(90, 54));
        System.out.println(execricio7(vetor2, 3, 0));
        System.out.println(execricio8(132));
        System.out.println(execricio9(12));

    }


}