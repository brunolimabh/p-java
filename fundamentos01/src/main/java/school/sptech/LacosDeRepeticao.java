package school.sptech;

public class LacosDeRepeticao {
    public static void main(String[] args) {

        System.out.println("for de 0 a 10");
        for (Integer i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("while de 0 a 10");
        Integer contador = 0;
        while (contador <= 10) {
            System.out.println(contador);
            contador++;
        }

        System.out.println("do while de 0 a 10");
        Integer contador2 = 0;
        // primeiro ele faz o q esta dentro do "do" e depois verifica o while
        do {
            System.out.println(contador2);
            contador2++;
        } while (contador2 <= 10);
    }
}
