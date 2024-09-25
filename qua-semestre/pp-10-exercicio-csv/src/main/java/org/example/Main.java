package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner iptString = new Scanner(System.in);
        Scanner iptNumber = new Scanner(System.in);

        int escolha = 0;
        List<Musica> musicas = new ArrayList<>();

        do {
            System.out.println("""
                    1 - Adicionar um objeto na lista (cadastro)
                    2 - Exibir os objetos cadastrados
                    3 - Grava arquivo CSV
                    4 - Lê arquivo CSV e exibe dados lidos
                    5 - Sair \s
                    """);
            escolha = iptNumber.nextInt();

            if (escolha == 1) {
                Musica novaMusica = new Musica();
                novaMusica.setId(musicas.size()+1);

                System.out.println("Nome da música:");
                novaMusica.setNome(iptString.nextLine());

                System.out.println("Nome do cantor:");
                novaMusica.setCantor(iptString.nextLine());

                System.out.println("Duração da música:");
                novaMusica.setDuracao(iptNumber.nextDouble());

                System.out.println("Nome do album:");
                novaMusica.setAlbum(iptString.nextLine());

                musicas.add(novaMusica);
            } else if (escolha == 2) {
                for (Musica musicaDaVez: musicas) {
                    System.out.println(musicaDaVez);
                }
            } else if (escolha == 3) {
                if (musicas.isEmpty()) {
                    System.out.println("Lista vazia. Não há nada a gravar");
                } else {
                    System.out.println("Digite o nome do arquivo a ser salvo: ");
                    gravaArquivoCsv(musicas, iptString.nextLine());
                }
            } else if (escolha == 4) {
                System.out.println("Digite o nome do arquivo a ser lido: ");
                leArquivoCsv(iptString.nextLine());
            } else {
                System.out.println("Até a próxima");
            }

        } while (escolha != 5);
    }
    public static void gravaArquivoCsv(List<Musica> lista, String nomeArq) {
        FileWriter arq = null;  // objeto que representa o arquivo
        Formatter saida = null; // objeto que sera usado para escrever no arquivo
        Boolean deuRuim = false;

        nomeArq += ".csv";  // Acrescenta a extensao .csv ao nome do arquivo

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (Musica musica : lista) {
                // NAO acrescentar espacos entre os formatos e os ;
                // NAO colocar tamanho de coluna tipo %10d
                // NAO colocar ponto e virgula antes o \n
                saida.format("%d;%s;%s;%.2f;%s\n",
                        musica.getId(),
                        musica.getNome(),
                        musica.getCantor(),
                        musica.getDuracao(),
                        musica.getAlbum());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo inexistente");
            System.exit(1);
        }

        try {
            System.out.println("\nDados lidos do arquivo:");
            System.out.printf("%4S %-15S %-9S %8S %-9S\n", "id", "nome", "cantor", "duração", "album");
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                String nome = entrada.next();
                String cantor = entrada.next();
                Double duracao = entrada.nextDouble();
                String album = entrada.nextLine();

                // Exibe na console os dados do cachorro lido do arquivo
                System.out.printf("%4d %-15s %-9s %8.2f %-9s\n", id, nome, cantor, duracao, album);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
