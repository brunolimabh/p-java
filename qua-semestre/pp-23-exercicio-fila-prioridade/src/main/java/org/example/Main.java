package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Musica> musicas = new ArrayList<>();
        musicas.add(new Musica(1, "teste1","teste1", "01:11","teste1", 1.1, "teste1", 5));
        musicas.add(new Musica(2, "teste2","teste2", "02:22","teste2", 2.2, "teste2", 3));
        musicas.add(new Musica(3, "teste3","teste3", "03:33","teste3", 3.4, "teste3", 1));
        musicas.add(new Musica(4, "teste4","teste4", "04:44","teste4", 4.4, "teste4", 2));
        musicas.add(new Musica(5, "teste5","teste5", "05:55","teste5", 5.6, "teste5", 4));

        Scanner iptString = new Scanner(System.in);
        Scanner iptNumber = new Scanner(System.in);
        int escolha = 0;

        FilaPrioridade fila = new FilaPrioridade(5);

        do {
            System.out.println("""
                    1 - Inserir 5 objetos
                    2 - Remover
                    3 - Exibir
                    4 - Fim \s
                    """);
            escolha = iptNumber.nextInt();

            if (escolha == 1) {
                System.out.println("Inserindo músicas...");
                for (Musica musica:musicas) {
                    fila.inserir(musica);
                }
                System.out.println("Músicas inseridas!");
            } else if (escolha == 2) {
                System.out.println(fila.remover());
            } else if (escolha == 3) {
                fila.exibirHeap();
            } else if (escolha == 4) {
                System.out.println("Até a próxima");
            } else {
                System.out.println("Opção inválida");
            }
        } while (escolha != 4);
    }
}