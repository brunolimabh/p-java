package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    5 - Grava arquivo TXT
                    6 - Lê arquivo TXT e exibe dados lidos
                    7 - Sair \s
                    """);
            escolha = iptNumber.nextInt();

            if (escolha == 1) {
                Musica novaMusica = new Musica();
                novaMusica.setId(musicas.size()+1);

                System.out.println("Nome da música:");
                novaMusica.setNome(iptString.nextLine());

                System.out.println("Nome do cantor:");
                novaMusica.setArtista(iptString.nextLine());

                System.out.println("Duração da música:");
                novaMusica.setDuracao(iptString.nextLine());

                System.out.println("Nome do album:");
                novaMusica.setAlbum(iptString.nextLine());

                System.out.println("Nota da música:");
                novaMusica.setNota(iptNumber.nextDouble());

                System.out.println("Gênero da música:");
                novaMusica.setGenero(iptString.nextLine());

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
            } else if (escolha == 5) {
                if (musicas.isEmpty()) {
                    System.out.println("Lista vazia. Não há nada a gravar");
                } else {
                    System.out.println("Digite o nome do arquivo a ser salvo: ");
                    gravaArquivoTxt(musicas, iptString.nextLine());
                }
            } else if (escolha == 6) {
                System.out.println("Digite o nome do arquivo a ser lido: ");
                leArquivoTxt(iptString.nextLine());
            } else {
                System.out.println("Até a próxima");
            }

        } while (escolha != 7);
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
                saida.format("%d;%s;%s;%s;%s;%.2f;%s\n",
                        musica.getId(),
                        musica.getNome(),
                        musica.getArtista(),
                        musica.getDuracao(),
                        musica.getAlbum(),
                        musica.getNota(),
                        musica.getGenero());
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

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;


        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }
    }

    public static void gravaArquivoTxt(List<Musica> lista, String nomeArq) {
        int contaRegDados = 0;

        if (lista.isEmpty()) {
            System.out.println("Lista vazia. Não há nada a gravar!");
        } else {

            String header = "00MUSICAS";
            header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            header += "01";
            gravaRegistro(nomeArq, header);

            String corpo;
            for (Musica a: lista) {
                corpo = "02";
                corpo += String.format("%04d", a.getId());
                corpo += String.format("%-20.20S", a.getNome());
                corpo += String.format("%-20.20S", a.getArtista());
                corpo += String.format("%5.5S", a.getDuracao());
                corpo += String.format("%-20.20S", a.getAlbum());
                corpo += String.format("%05.2f", a.getNota());
                corpo += String.format("%-10.10S", a.getGenero());

                gravaRegistro(nomeArq, corpo);
                contaRegDados++;
            }

            String trailer = "01";
            trailer +=  String.format("%010d", contaRegDados);
            gravaRegistro(nomeArq, trailer);

            System.out.println("Gravação efetuada com sucesso");
        }
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer id;
        String nome, artista, duracao, album, genero;
        Double nota;
        int contaRegDados = 0;
        int qtdRegGravados;

        List<Musica> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader((new FileReader(nomeArq)));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2,9));
                    System.out.println("Data e hora da gravação do arquivo: " + registro.substring(9,28));
                    System.out.println("Versão do documento de layout: " + registro.substring(28,29));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegGravados = Integer.parseInt(registro.substring(2,12));
                    if (contaRegDados == qtdRegGravados) {
                        System.out.println("Qtd. de reg. campatível com qtd. de reg. de dados lidos");
                    } else {
                        System.out.println("Qtd. de reg. incampatível com qtd. de reg. de dados lidos");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de dados");

                    id = Integer.parseInt(registro.substring(2,6));
                    nome = registro.substring(6,26).trim();
                    artista = registro.substring(26,46).trim();
                    duracao = registro.substring(46,51);
                    album = registro.substring(51,71).trim();
                    nota = Double.valueOf(registro.substring(71,76).replace(',', '.'));
                    genero = registro.substring(76,86).trim();

                    Musica a = new Musica(id, nome, artista, duracao, album, nota, genero);
                    listaLida.add(a);
                } else {
                    System.out.println("Registro inválido");
                }

                registro = entrada.readLine();
            }
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: ");
            erro.printStackTrace();
        }

        System.out.println("\n Lista lida das musicas: ");
        for (Musica a: listaLida) {
            System.out.println(a);
        }
    }
}
