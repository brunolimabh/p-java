package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fruta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a fruta desejada:");
        String iptFruta = input.nextLine();

        List<String> listaFrutas = new ArrayList();
        listaFrutas.add("Maça");
        listaFrutas.add("Abacaxi");
        listaFrutas.add("Banana");
        listaFrutas.add("Pera");
        listaFrutas.add("Laranja");
        listaFrutas.add("Melão");

        boolean isExiste = false;
        for (int i = 0; i < listaFrutas.size(); i++) {
            if (listaFrutas.get(i).equalsIgnoreCase(iptFruta)) {
                System.out.println("A fruta %s existe na lista e está na %d posição"
                        .formatted(iptFruta,i+1));
                isExiste = true;
            }
        }

        if (!isExiste) {
            System.out.println("Não existe a fruta %s na lista".formatted(iptFruta));
        }




    }
}
