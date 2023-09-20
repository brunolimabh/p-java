package school.sptech;

public class NumerosPares {
    public static void main(String[] args) {
        System.out.println("Exercício 04 - Números Pares\n");

        Integer cont = 0;
        while (cont <= 40){
            if (cont %2 == 0) {
                System.out.println(cont);
            }
            cont++;
        }
    }
}
