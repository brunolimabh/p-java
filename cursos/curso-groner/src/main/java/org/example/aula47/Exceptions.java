package org.example.aula47;

public class Exceptions {

    public static void main(String[] args) {
        int [] vetor = new int[4];

        // ArrayIndexOutOfBoundsException
        // Acessar um array que não existe

        // vetor[4] = 1;

        try {
            vetor[4] = 1;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exceção ao acessar um indice do vetor que não existe");
        }
    }
}
