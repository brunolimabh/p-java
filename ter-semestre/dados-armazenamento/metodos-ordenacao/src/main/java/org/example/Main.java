package org.example;


public class Main {

    public void mergeSort(int p, int r, int[] v){
        if (p < r - 1) {
            int q = (p+r) / 2;
            mergeSort(p,q,v);
            mergeSort(p,r,v);
            intercala(p,q,r,v);
        }
    }

    public void intercala(int p, int q, int r, int[] v){

    }
}