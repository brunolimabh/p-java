package org.example;

public class Main {
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(4);
        fila.insert("ola");
        fila.insert("ol");
        fila.insert("oa");
        fila.insert("la");
        fila.exibe();
    }
}